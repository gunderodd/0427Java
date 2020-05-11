package com.hackbank.persistence.dao.approval;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.hackbank.business.exceptions.BusinessException;
import com.hackbank.persistence.dbutil.SingletonDBConnection;
import com.hackbank.persistence.models.PendingApproval;

public class PendingApprovalDAOImpl implements PendingApprovalDAO{

	final static Logger loggy = Logger.getLogger(PendingApprovalDAOImpl.class);
	
	@Override
	public void createApproval(PendingApproval pApproval) throws BusinessException{
		loggy.setLevel(Level.INFO);
		try(Connection conn = SingletonDBConnection.getConnection()){
			String query = "{CALL CREATE_P_APPROVAL(?,?,?,?,?)}";
			CallableStatement call = conn.prepareCall(query);
			call.setString("PERSON_ID", pApproval.getPerson().getId());
			call.setShort("ACCOUNT_TYPE_ID", pApproval.getAccountTypeId());
			call.setDouble("START_BALANCE", pApproval.getStartBalance());
			call.setString("STATUS", pApproval.getStatus());
			call.setDate("CREATED_AT", new java.sql.Date(pApproval.getCreatedAt().getTime()));
			boolean validExe = call.execute();
			if (validExe) {
				System.out.println("Execution successful");
			}
		} catch (ClassNotFoundException | SQLException e) {
			loggy.error("Fatal Error contact SYSADMIN.");
			throw new BusinessException("Fatal error contact SYSADMIN.");
		}
		
	}

}