package org.clean.hexarch.adapter.restapi;

import org.clean.hexarch.adapter.restapi.data.FlowMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "uvpInterface")
@RequestMapping("/rest/uvpinterface/v1")
@RestController
public class InterfaceController {
  private RequestAdapter dispatcher = new RequestAdapter();

  @Operation(summary = "Submit Uvp Interface Request")
  @ApiResponses(value = { @ApiResponse(responseCode = "401", description = "Authentication Required"),
      @ApiResponse(responseCode = "403", description = "Not Authorized"),
      @ApiResponse(responseCode = "404", description = "Order not found"),
      @ApiResponse(responseCode = "500", description = "Unexpected Runtime error") })
  @PostMapping(path = "request")
  public void submitRequest(@Parameter(name = "Workflow Request Message") HttpEntity<FlowMessage> httpEntity) {
    FlowMessage request = httpEntity.getBody();
    HttpHeaders httpHeaders = httpEntity.getHeaders();
    log.debug("submitRequest() received request: {} with headers: {}", request, httpHeaders);

    dispatcher.handleWorkflowRequest(request);
  }
}
