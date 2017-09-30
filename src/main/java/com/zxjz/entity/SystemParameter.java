package com.zxjz.entity;

public class SystemParameter {
    private String parameter;
    private String parameterName;
    private String parameterDescription;
    private int parameterId;
    private int serialNumber;


    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterDescription() {
        return parameterDescription;
    }

    public void setParameterDescription(String parameterDescription) {
        this.parameterDescription = parameterDescription;
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "SystemParameter{" +
                "parameter='" + parameter + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", parameterDescription='" + parameterDescription + '\'' +
                ", parameterId=" + parameterId +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
