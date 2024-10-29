package com.imag.spring_resttemplate_example.model.request;

public class AccountInformationDTO {
    private String customerCode;

    public void setCustomerCode(String customerCode) {
        this.customerCode=customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public AccountInformationDTO(AccountAPIClient accountAPIClient){

    }
    public AccountInformationDTO(){

    }
}
