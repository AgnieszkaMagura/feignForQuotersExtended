package com.example.feignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "quotesClient", url = "http://localhost:8080")
public interface QuotesClient {

    // GET /apiWithHeader (header: requestId: someId)
   @GetMapping("/apiWithHeader")
    List<QuoteResponse> getAllWithHeader(@RequestHeader("requestId") String requestId);

   // GET /apiWithRequestParam?id=11
    @GetMapping("/apiWithRequestParam")
    QuoteResponse getQuoteById(@RequestParam("id") Long id);

    // POST /api/quote/12
    @PostMapping("/api/quote")
    QuoteResponse createQuote(@RequestBody QuoteRequest quoteRequest);

    //DELETE /api/quote/12
    @DeleteMapping("api/quote/{id}")
    QuoteResponse deleteQuoteById(@PathVariable("id") Long id);

}
