package com.example.feignforquotersextended;


import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
@Log4j2
public class FeignForQuotesExtendedApplication {

    @Autowired
    private QuotesClient quotesClient;


    public static void main(String[] args) {
        SpringApplication.run(FeignForQuotesExtendedApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testFeign() {

        try {
        // GET /apiWithHeader with header "requestId: someID"
        log.info("=== GET /apiWithHeader z nagłówkiem requestId ===");
        List<QuoteResponse> headerResponses = quotesClient.getAllWithHeader("someID");
        headerResponses.forEach(resp -> log.info("Response from header call: {}", resp));

        // GET /apiWithRequestParam?id=11
        log.info("=== GET /apiWithRequestParam?id=11 ===");
        QuoteResponse byId = quotesClient.getQuoteById(11L);
        log.info("Response from request param call: {}", byId);

        // POST /api/quote {\"quote\": \"some quote\"}
        log.info("=== POST /api/quote ===");
        QuoteRequest newQuote = new QuoteRequest("some quote");
        QuoteResponse created = quotesClient.createQuote(newQuote);
        log.info("Created quote: {}", created);

        // DELETE /api/quote/12
        log.info("=== DELETE /api/quote/12 ===");
        QuoteResponse deleted = quotesClient.deleteQuote(12L);
        log.info("Delete response: {}", deleted);

        } catch (FeignException.FeignClientException feignException) {
            log.error("client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            log.error("server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            log.error("retryable exception" + retryableException.getMessage());
        } catch (FeignException feignException) {
            log.error(feignException.getMessage());
            log.error(feignException.status());
        }
    }
}


