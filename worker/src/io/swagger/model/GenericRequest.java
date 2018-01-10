package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Date;

public class GenericRequest {

    private String parameter = null;
    private String executor = null;

    public GenericRequest(String parameter, String executor) {
        this.parameter = parameter;
        this.executor = executor;
    }

    public enum SystemEnum {
        URA("URA"),
        APP("APP");
        private String value;

        SystemEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private SystemEnum system = null;

    public enum ParamTypeEnum {
        INSTANCIA("INSTANCIA"),
        WORKORDER_ID("WORKORDER_ID");
        private String value;

        ParamTypeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ParamTypeEnum paramType = null;
    private Date requestDate = null;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    @JsonProperty("system")
    public SystemEnum getSystem() {
        return system;
    }

    public void setSystem(SystemEnum system) {
        this.system = system;
    }

    @JsonProperty("paramType")
    public ParamTypeEnum getParamType() {
        return paramType;
    }

    public void setParamType(ParamTypeEnum paramType) {
        this.paramType = paramType;
    }

    /**
     * Data da solicitação
     *
     */
    @JsonProperty("requestDate")
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenericRequest genericRequest = (GenericRequest) o;
        return Objects.equals(parameter, genericRequest.parameter)
                && Objects.equals(executor, genericRequest.executor)
                && Objects.equals(system, genericRequest.system)
                && Objects.equals(paramType, genericRequest.paramType)
                && Objects.equals(requestDate, genericRequest.requestDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter, executor, system, paramType, requestDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenericRequest {\n");

        sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
        sb.append("    executor: ").append(toIndentedString(executor)).append("\n");
        sb.append("    system: ").append(toIndentedString(system)).append("\n");
        sb.append("    paramType: ").append(toIndentedString(paramType)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
