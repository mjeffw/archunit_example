package org.clean.hexarch.adapter.restapi;

import java.util.HashMap;

import org.clean.hexarch.adapter.restapi.data.FlowMessage;

class ContextMapperUtil {
  static HashMap<String, Object> toContext(FlowMessage message) {
    HashMap<String, Object> result = new HashMap<>();

    result.put("MessageType", message.getMessageType());
    result.put("Action", message.getAction());

    result.put("Ban", message.getBan());
    result.put("FlowableId", message.getFlowableId());
    result.put("orderVersionNumber", message.getOrderVersionNumber());
    result.put("FlowableType", message.getFlowableType());
    result.put("ProductType", message.getProductType());
    result.put("Timestamp", message.getTimestamp());
    result.put("Priority", message.getPriority());

    result.put("CorrelationId", message.getCorrelationId());
    result.put("RetriedCount", message.getRetriedCount());
    result.put("Status", message.getStatus());

    result.put("WorkflowId", message.getWorkflowId());
    result.put("WorkflowVersion", message.getWorkflowVersion());
    result.put("WorkflowTaskId", message.getWorkflowTaskId());
    result.put("WorkflowTaskBo", message.getWorkflowTaskBo());
    result.put("TaskDefinitionId", message.getTaskDefinitionId());

    result.put("ForceIndicator", message.isForceIndicator());
    result.put("NoOpIndicator", message.isNoOpIndicator());

    result.put("ErrorCode", message.getErrorCode());
    result.put("ErrorDescription", message.getErrorDescription());

    result.put("Attributes", message.getAttributes());

    return result;
  }
}
