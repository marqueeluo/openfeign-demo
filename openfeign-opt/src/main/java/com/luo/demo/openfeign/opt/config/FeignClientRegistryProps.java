package com.luo.demo.openfeign.opt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FeignClient注册
 *
 * @author luohq
 * @date 2021-09-14
 */
@ConfigurationProperties(prefix = FeignClientRegistryProps.PREFIX)
public class FeignClientRegistryProps {
    public static final String PREFIX = "feign.client";

    private List<FeignClientRegistry> registry;

    public List<FeignClientRegistry> getRegistry() {
        return registry;
    }

    public void setRegistry(List<FeignClientRegistry> registry) {
        this.registry = registry;
    }

    /**
     * 搬运 {@link org.springframework.cloud.openfeign.FeignClient} 注解的属性 - DTO
     */
    public static class FeignClientRegistry {

        /**
         * The name of the service with optional protocol prefix. Synonym for {@link #name()
         * name}. A name must be specified for all clients, whether or not a url is provided.
         * Can be specified as property key, eg: ${propertyKey}.
         *
         * @return the name of the service with optional protocol prefix
         */
        private String name = "";

        /**
         * 被代理的feignClient接口类
         */
        private Class<?> target;

        /**
         * This will be used as the bean name instead of name if present, but will not be used
         * as a service id.
         *
         * @return bean name instead of name if present
         */
        private String contextId = "";

        /**
         * @return the <code>@Qualifiers</code> value for the feign client.
         *
         * If both {@link #qualifier()} and {@link #qualifiers()} are present, we will use the
         * latter, unless the array returned by {@link #qualifiers()} is empty or only
         * contains <code>null</code> or whitespace values, in which case we'll fall back
         * first to {@link #qualifier()} and, if that's also not present, to the default =
         * <code>contextId + "FeignClient"</code>.
         */
        private String[] qualifiers = {};
        /**
         * @return an absolute URL or resolvable hostname (the protocol is optional).
         */
        private String url;

        /**
         * @return whether 404s should be decoded instead of throwing FeignExceptions
         */
        private boolean decode404 = false;

        /**
         * A custom configuration class for the feign client. Can contain override
         * <code>@Bean</code> definition for the pieces that make up the client, for instance
         * {@link feign.codec.Decoder}, {@link feign.codec.Encoder}, {@link feign.Contract}.
         *
         * @return list of configurations for feign client
         * @see FeignClientsConfiguration for the defaults
         */
        Class<?>[] configuration = {};

        /**
         * Fallback class for the specified Feign client interface. The fallback class must
         * implement the interface annotated by this annotation and be a valid spring bean.
         *
         * @return fallback class for the specified Feign client interface
         */
        private Class<?> fallback = void.class;

        /**
         * Define a fallback factory for the specified Feign client interface. The fallback
         * factory must produce instances of fallback classes that implement the interface
         * annotated by {@link FeignClient}. The fallback factory must be a valid spring bean.
         *
         * @return fallback factory for the specified Feign client interface
         * @see FallbackFactory for details.
         */
        private Class<?> fallbackFactory = void.class;

        /**
         * @return path prefix to be used by all method-level mappings.
         */
        private String path = "";

        /**
         * @return whether to mark the feign proxy as a primary bean. Defaults to true.
         */
        private boolean primary = true;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public Class<?> getTarget() {
            return target;
        }

        public void setTarget(Class<?> target) {
            this.target = target;
        }

        public String getContextId() {
            return contextId;
        }

        public void setContextId(String contextId) {
            this.contextId = contextId;
        }

        public String[] getQualifiers() {
            return qualifiers;
        }

        public void setQualifiers(String[] qualifiers) {
            this.qualifiers = qualifiers;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isDecode404() {
            return decode404;
        }

        public void setDecode404(boolean decode404) {
            this.decode404 = decode404;
        }

        public Class<?>[] getConfiguration() {
            return configuration;
        }

        public void setConfiguration(Class<?>[] configuration) {
            this.configuration = configuration;
        }

        public Class<?> getFallback() {
            return fallback;
        }

        public void setFallback(Class<?> fallback) {
            this.fallback = fallback;
        }

        public Class<?> getFallbackFactory() {
            return fallbackFactory;
        }

        public void setFallbackFactory(Class<?> fallbackFactory) {
            this.fallbackFactory = fallbackFactory;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public boolean isPrimary() {
            return primary;
        }

        public void setPrimary(boolean primary) {
            this.primary = primary;
        }

        public Map<String, Object> toAttributes() {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("name", this.name);
            attributes.put("target", this.target);
            attributes.put("contextId", this.contextId);
            attributes.put("qualifiers", this.qualifiers);
            attributes.put("url", this.url);
            attributes.put("decode404", this.decode404);
            attributes.put("configuration", this.configuration);
            attributes.put("fallback", this.fallback);
            attributes.put("fallbackFactory", this.fallbackFactory);
            attributes.put("path", this.path);
            attributes.put("primary", this.primary);
            return attributes;
        }

        @Override
        public String toString() {
            return "FeignClientRegistry{" +
                    "name='" + name + '\'' +
                    ", target=" + target +
                    ", contextId='" + contextId + '\'' +
                    ", qualifiers=" + Arrays.toString(qualifiers) +
                    ", url='" + url + '\'' +
                    ", decode404=" + decode404 +
                    ", configuration=" + Arrays.toString(configuration) +
                    ", fallback=" + fallback +
                    ", fallbackFactory=" + fallbackFactory +
                    ", path='" + path + '\'' +
                    ", primary=" + primary +
                    '}';
        }
    }
}
