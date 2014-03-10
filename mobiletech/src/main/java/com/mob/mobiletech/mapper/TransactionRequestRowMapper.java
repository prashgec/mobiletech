/**
 * 
 */
package com.mob.mobiletech.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mob.mobiletech.domain.TransactionRequest;

/**
 * @author Prashant
 *
 */
public class TransactionRequestRowMapper implements RowMapper<TransactionRequest> {

	@Override
	public TransactionRequest mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		TransactionRequest tnx= new TransactionRequest();
		/*tnx.setCreateDate(rs.getString("registered_on"));
		tnx.setRequestedBy(rs.getInt("prntid"));
		tnx.set*/
		
		
		return tnx;
	}

}
