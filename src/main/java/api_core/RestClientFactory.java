package api_core;

import io.qameta.allure.jaxrs.AllureJaxRs;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;

@Slf4j
public class RestClientFactory {

    public static final long DEFAULT_TIMEOUT = 180000;
    private JAXRSClientFactoryBean jaxrsClientFactoryBean;

    public RestClientFactory() {
        jaxrsClientFactoryBean = new JAXRSClientFactoryBean();
        jaxrsClientFactoryBean.setProvider(new AllureJaxRs());
    }

    public <T> T createClient(Class<T> client, String address) {
        jaxrsClientFactoryBean.setServiceClass(client);
        jaxrsClientFactoryBean.setAddress(address);
        configureTimeouts(client);
        return (T) client;
    }

    private <T> void configureTimeouts(T client) {
        log.debug("Configuring timeouts...");
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(DEFAULT_TIMEOUT);
        conduit.getClient().setConnectionTimeout(DEFAULT_TIMEOUT);
        conduit.getClient().setAsyncExecuteTimeout(DEFAULT_TIMEOUT);
    }

}
