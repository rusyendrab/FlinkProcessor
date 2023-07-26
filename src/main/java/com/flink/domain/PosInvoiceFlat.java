package com.flink.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InvoiceNumber",
    "CreatedTime",
    "StoreID",
    "PosID",
    "CashierID",
    "CustomerType",
    "CustomerCardNo",
    "TotalAmount",
    "NumberOfItems",
    "PaymentMethod",
    "TaxableAmount",
    "CGST",
    "SGST",
    "CESS",
    "DeliveryType",

    "AddressLine",
    "City",
    "State",
    "PinCode",
    "ContactNumber",

    "ItemCode",
    "ItemDescription",
    "ItemPrice",
    "ItemQty",
    "TotalValue"
})
public class PosInvoiceFlat implements Serializable {

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("CreatedTime")
    private Long createdTime;
    @JsonProperty("StoreID")
    private String storeID;
    @JsonProperty("PosID")
    private String posID;
    @JsonProperty("CashierID")
    private String cashierID;
    @JsonProperty("CustomerType")
    private String customerType;
    @JsonProperty("CustomerCardNo")
    private String customerCardNo;
    @JsonProperty("TotalAmount")
    private Double totalAmount;
    @JsonProperty("NumberOfItems")
    private Integer numberOfItems;
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @JsonProperty("TaxableAmount")
    private Double taxableAmount;
    @JsonProperty("CGST")
    private Double cGST;
    @JsonProperty("SGST")
    private Double sGST;
    @JsonProperty("CESS")
    private Double cESS;
    @JsonProperty("DeliveryType")
    private String deliveryType;

    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PinCode")
    private String pinCode;
    @JsonProperty("ContactNumber")
    private String contactNumber;

    @JsonProperty("ItemCode")
    private String itemCode;
    @JsonProperty("ItemDescription")
    private String itemDescription;
    @JsonProperty("ItemPrice")
    private Double itemPrice;
    @JsonProperty("ItemQty")
    private Integer itemQty;
    @JsonProperty("TotalValue")
    private Double totalValue;

    @JsonProperty("InvoiceNumber")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("CreatedTime")
    public Long getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("CreatedTime")
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("StoreID")
    public String getStoreID() {
        return storeID;
    }

    @JsonProperty("StoreID")
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    @JsonProperty("PosID")
    public String getPosID() {
        return posID;
    }

    @JsonProperty("PosID")
    public void setPosID(String posID) {
        this.posID = posID;
    }

    @JsonProperty("CashierID")
    public String getCashierID() {
        return cashierID;
    }

    @JsonProperty("CashierID")
    public void setCashierID(String cashierID) {
        this.cashierID = cashierID;
    }

    @JsonProperty("CustomerType")
    public String getCustomerType() {
        return customerType;
    }

    @JsonProperty("CustomerType")
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @JsonProperty("CustomerCardNo")
    public String getCustomerCardNo() {
        return customerCardNo;
    }

    @JsonProperty("CustomerCardNo")
    public void setCustomerCardNo(String customerCardNo) {
        this.customerCardNo = customerCardNo;
    }

    @JsonProperty("TotalAmount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("TotalAmount")
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("NumberOfItems")
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    @JsonProperty("NumberOfItems")
    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @JsonProperty("PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("PaymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("TaxableAmount")
    public Double getTaxableAmount() {
        return taxableAmount;
    }

    @JsonProperty("TaxableAmount")
    public void setTaxableAmount(Double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    @JsonProperty("CGST")
    public Double getCGST() {
        return cGST;
    }

    @JsonProperty("CGST")
    public void setCGST(Double cGST) {
        this.cGST = cGST;
    }

    @JsonProperty("SGST")
    public Double getSGST() {
        return sGST;
    }

    @JsonProperty("SGST")
    public void setSGST(Double sGST) {
        this.sGST = sGST;
    }

    @JsonProperty("CESS")
    public Double getCESS() {
        return cESS;
    }

    @JsonProperty("CESS")
    public void setCESS(Double cESS) {
        this.cESS = cESS;
    }

    @JsonProperty("DeliveryType")
    public String getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("DeliveryType")
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("AddressLine")
    public String getAddressLine() {
        return addressLine;
    }

    @JsonProperty("AddressLine")
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("PinCode")
    public String getPinCode() {
        return pinCode;
    }

    @JsonProperty("PinCode")
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @JsonProperty("ContactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("ContactNumber")
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @JsonProperty("ItemCode")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("ItemCode")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @JsonProperty("ItemDescription")
    public String getItemDescription() {
        return itemDescription;
    }

    @JsonProperty("ItemDescription")
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @JsonProperty("ItemPrice")
    public Double getItemPrice() {
        return itemPrice;
    }

    @JsonProperty("ItemPrice")
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @JsonProperty("ItemQty")
    public Integer getItemQty() {
        return itemQty;
    }

    @JsonProperty("ItemQty")
    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    @JsonProperty("TotalValue")
    public Double getTotalValue() {
        return totalValue;
    }

    @JsonProperty("TotalValue")
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("createdTime", createdTime).append("storeID", storeID).append("posID", posID).append("cashierID", cashierID).append("customerType", customerType).append("customerCardNo", customerCardNo).append("totalAmount", totalAmount).append("numberOfItems", numberOfItems).append("paymentMethod", paymentMethod).append("taxableAmount", taxableAmount).append("cGST", cGST).append("sGST", sGST).append("cESS", cESS)
                .append("deliveryType", deliveryType)
                .append("addressLine", addressLine).append("city", city).append("state", state).append("pinCode", pinCode).append("contactNumber", contactNumber)
                .append("itemCode", itemCode).append("itemDescription", itemDescription).append("itemPrice", itemPrice).append("itemQty", itemQty).append("totalValue", totalValue)
                .toString();
    }

    public PosInvoiceFlat() {
    }

    public PosInvoiceFlat(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public PosInvoiceFlat(String invoiceNumber, Long createdTime, String storeID, String posID, String cashierID, String customerType, String customerCardNo, Double totalAmount, Integer numberOfItems, String paymentMethod, Double taxableAmount, Double cGST, Double sGST, Double cESS, String deliveryType, String addressLine, String city, String state, String pinCode, String contactNumber, String itemCode, String itemDescription, Double itemPrice, Integer itemQty, Double totalValue) {
        this.invoiceNumber = invoiceNumber;
        this.createdTime = createdTime;
        this.storeID = storeID;
        this.posID = posID;
        this.cashierID = cashierID;
        this.customerType = customerType;
        this.customerCardNo = customerCardNo;
        this.totalAmount = totalAmount;
        this.numberOfItems = numberOfItems;
        this.paymentMethod = paymentMethod;
        this.taxableAmount = taxableAmount;
        this.cGST = cGST;
        this.sGST = sGST;
        this.cESS = cESS;
        this.deliveryType = deliveryType;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.contactNumber = contactNumber;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.totalValue = totalValue;
    }
}
