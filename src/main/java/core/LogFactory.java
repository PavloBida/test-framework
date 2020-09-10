package core;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.InputStream;

public class LogFactory {

    /**
     * This logger must be initalized in each class that wants to use it.
     * private static final Logger LOG = LogFactory.getLogger(<CLASS_NAME>.class);
     */
	private static LoggerContext factory = (LoggerContext) LoggerFactory
			.getILoggerFactory();
	
	private static Logger logger;

	static {
		try {
			init(FileReader.class.getResourceAsStream("/logback.xml"));
		} catch (IllegalArgumentException e) {
			System.err
					.println("failed to load logging configuration from logback.xml");
			e.printStackTrace(System.err);
			throw new RuntimeException(
					"no file logback in resources folder found", e);
		}
	}

	public static void init(InputStream logParams) {
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(factory);
			if (logParams != null) {
				factory.reset();
				configurator.doConfigure(logParams);
			}
		} catch (JoranException je) { // catch-22 situation here: can't log an
										// error if the logger can't be
										// created! Possibly the only valid use
										// case for printStackTrace()...
			je.printStackTrace();
		}
		StatusPrinter.printIfErrorsOccured(factory);
		logger = getLogger(LogFactory.class);
		logger.info("-------------------------Initializing logger-------------------------");
	}

	/**
	 * @param clazz
	 * @return the associated Logger object
	 */
	public static Logger getLogger(
			@SuppressWarnings("rawtypes") Class clazz) {
		return LoggerFactory.getLogger(clazz);
	}

}
