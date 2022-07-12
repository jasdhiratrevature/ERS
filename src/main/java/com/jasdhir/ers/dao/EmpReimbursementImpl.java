package com.jasdhir.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jasdhir.ers.model.Reimbursement;
import com.jasdhir.ers.utils.ConnectionUtils;

public class EmpReimbursementImpl implements EmpReimbursement{
Connection dbConnect=null;
	@Override
	public List getAllRecords(int authorId) {
		// TODO Auto-generated method stub
		List<Reimbursement> allRecords=new ArrayList<Reimbursement>();
		Reimbursement reimbursement;
		try {
			dbConnect=ConnectionUtils.getInstance().getConnection();
			String sqlRecords="select * from ersreim where authorid=?";
			PreparedStatement getAllRemi=dbConnect.prepareStatement(sqlRecords);
			getAllRemi.setInt(1, authorId);
			ResultSet resultSet=getAllRemi.executeQuery();
			while(resultSet.next()) {
				reimbursement=new Reimbursement();
				reimbursement.setReimbursementId(resultSet.getInt(1));
				reimbursement.setAccepted(resultSet.getBoolean(2));
				reimbursement.setReimbursementType(resultSet.getString(5));
				reimbursement.setDescription(resultSet.getString(4));
				reimbursement.setAmount(resultSet.getDouble(3));
				reimbursement.setResolveTime(resultSet.getString(6));
				reimbursement.setResolved(resultSet.getBoolean(7));
				reimbursement.setSubmitTime(resultSet.getString(8));
				reimbursement.setAuthorId(resultSet.getInt(9));
				reimbursement.setResolverId(resultSet.getInt(10));
				
				allRecords.add(reimbursement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allRecords;
	}
	@Override
	public List getResolvedRecords(int authorId) {
		// TODO Auto-generated method stub
		List<Reimbursement> resolvedRecords=new ArrayList<Reimbursement>();
		Reimbursement reimbursement;
		try {
			dbConnect=ConnectionUtils.getInstance().getConnection();
			String sqlRecords="select * from ersreim where authorid=? and resolved=true";
			PreparedStatement getAllRemi=dbConnect.prepareStatement(sqlRecords);
			getAllRemi.setInt(1, authorId);
			ResultSet resultSet=getAllRemi.executeQuery();
			while(resultSet.next()) {
				reimbursement=new Reimbursement();
				reimbursement.setReimbursementId(resultSet.getInt(1));
				reimbursement.setAccepted(resultSet.getBoolean(2));
				reimbursement.setReimbursementType(resultSet.getString(5));
				reimbursement.setDescription(resultSet.getString(4));
				reimbursement.setAmount(resultSet.getDouble(3));
				reimbursement.setResolveTime(resultSet.getString(6));
				reimbursement.setResolved(resultSet.getBoolean(7));
				reimbursement.setSubmitTime(resultSet.getString(8));
				reimbursement.setAuthorId(resultSet.getInt(9));
				reimbursement.setResolverId(resultSet.getInt(10));
				
				resolvedRecords.add(reimbursement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resolvedRecords;
	}
	@Override
	public List getPendingRecords(int authorId) {
		// TODO Auto-generated method stub
		List<Reimbursement> pendingRecords=new ArrayList<Reimbursement>();
		Reimbursement reimbursement;
		try {
			dbConnect=ConnectionUtils.getInstance().getConnection();
			String sqlRecords="select * from ersreim where authorid=? and resolved=false";
			PreparedStatement getAllRemi=dbConnect.prepareStatement(sqlRecords);
			getAllRemi.setInt(1, authorId);
			ResultSet resultSet=getAllRemi.executeQuery();
			while(resultSet.next()) {
				reimbursement=new Reimbursement();
				reimbursement.setReimbursementId(resultSet.getInt(1));
				reimbursement.setAccepted(resultSet.getBoolean(2));
				reimbursement.setReimbursementType(resultSet.getString(5));
				reimbursement.setDescription(resultSet.getString(4));
				reimbursement.setAmount(resultSet.getDouble(3));
				reimbursement.setResolveTime(resultSet.getString(6));
				reimbursement.setResolved(resultSet.getBoolean(7));
				reimbursement.setSubmitTime(resultSet.getString(8));
				reimbursement.setAuthorId(resultSet.getInt(9));
				reimbursement.setResolverId(resultSet.getInt(10));
				
				pendingRecords.add(reimbursement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pendingRecords;
	}
	@Override
	public void saveRequest(int authorId, String remType, String remDesc, double amount) {
		// TODO Auto-generated method stub
		
	}
	

	

}
