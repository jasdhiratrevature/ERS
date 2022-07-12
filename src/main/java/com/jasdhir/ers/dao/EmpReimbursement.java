package com.jasdhir.ers.dao;

import java.util.List;



public interface EmpReimbursement {
List getAllRecords(int authorId);

List getResolvedRecords(int authorId);

List getPendingRecords(int authorId);

void saveRequest(int authorId,String remType,String remDesc,double amount);

}
