package dev.lukaszmichalak.regionalproducts.locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

class UrlLocaleChangeInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) {
        
        LocaleResolver localeResolver = getLocaleResolver(request);
        
        boolean isPl = request.getRequestURI().contains("/pl/");
        
        if (isPl) {
            localeResolver.setLocale(request, response, Locale.of("pl"));
        } else {
            localeResolver.setLocale(request, response, Locale.ENGLISH);
        }
        
        return true;
    }
    
    private LocaleResolver getLocaleResolver(HttpServletRequest request) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        
        return localeResolver;
    }
}
