package br.com.unisys.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import connection.BancoDeDados;

public class FornecedorDAO {
	private Connection cn;

	public FornecedorDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	//Metodo para Adicionar objeto na tabela
	public String adicionar(Fornecedor fornecedor) throws SQLException {

		try {
			
			String sql = "insert into fornecedores (codigoFor,nome) " + "values( ? ,?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getCodigoFornecedor());
			stmt.execute();
			
			return "OK";

		} catch (Exception e) {
		
			return e.toString();

		}
		
	}

}
