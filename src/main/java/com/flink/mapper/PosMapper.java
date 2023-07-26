package com.flink.mapper;

import com.flink.domain.DeliveryAddress;
import com.flink.domain.LineItem;
import com.flink.domain.PosInvoice;
import com.flink.domain.PosInvoiceFlat;

import java.util.ArrayList;
import java.util.List;

public class PosMapper {
    public List<PosInvoiceFlat> flattenPosInvoice(PosInvoice pos) {
        List<LineItem> lineItemList = new ArrayList<LineItem>();
        List<PosInvoiceFlat> posFlatList = new ArrayList<PosInvoiceFlat>();

        PosInvoiceFlat posf = null;
        for(LineItem item: pos.getInvoiceLineItems()) {
            if(item != null){
                posf = new PosInvoiceFlat();

                posf.setInvoiceNumber(pos.getInvoiceNumber());
                posf.setInvoiceNumber(pos.getInvoiceNumber());
                posf.setCreatedTime(pos.getCreatedTime());
                posf.setStoreID(pos.getStoreID());
                posf.setPosID(pos.getPosID());
                posf.setCashierID(pos.getCashierID());
                posf.setCustomerType(pos.getCustomerType());
                posf.setCustomerCardNo(pos.getCustomerCardNo());
                posf.setTotalAmount(pos.getTotalAmount());
                posf.setNumberOfItems(pos.getNumberOfItems());
                posf.setPaymentMethod(pos.getPaymentMethod());
                posf.setTaxableAmount(pos.getTaxableAmount());
                posf.setCGST(pos.getCGST());
                posf.setSGST(pos.getSGST());
                posf.setCESS(pos.getCESS());
                posf.setDeliveryType(pos.getDeliveryType());

                DeliveryAddress address = pos.getDeliveryAddress();
                if(address!=null ){
                    posf.setAddressLine(pos.getDeliveryAddress().getAddressLine());
                    posf.setCity(pos.getDeliveryAddress().getCity());
                    posf.setState(pos.getDeliveryAddress().getState());
                    posf.setPinCode(pos.getDeliveryAddress().getPinCode());
                    posf.setContactNumber(pos.getDeliveryAddress().getContactNumber());

                }
                posf.setItemCode(item.getItemCode());
                posf.setItemDescription(item.getItemDescription());
                posf.setItemPrice(item.getItemPrice());
                posf.setItemQty(item.getItemQty());
                posf.setTotalValue(item.getTotalValue());
                posFlatList.add(posf);
            }

        }
        return posFlatList;
    }
}
