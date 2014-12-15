/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author Trang Hoc
 */
public class editphong {
    Connection c=new getconnect().getcon();
    public editphong(String maphcu,String maphmoi,int loaiphong)
    {  
    stmt=c.createStatement();
	String sql;
	String loai;
	if(loaiphong==1)loai="nam";
	else if(loaiphong==2)loai="nu";
	else {
		JOptionPane.showMessageDialog(null, "ban hay chon loai phong cho ro rang");
		return;
		}
        try {
	Statement stmt =c.createStatement();
	sql="update phong set maph='"+maphmoi+"',songuoi=0,loaiphong='"+loai+"' where maph='"+maphcu+"';";			
	stmt.executeUpdate(sql);
	sql="delete from sinhvien where maph='"+maphcu+"';";
	stmt.executeUpdate(sql);
	sql="update diennuoc set dtt =0 ,dts =0 ,ntt =0 ,nts =0 ,sum_sd =0 ,sum_nc =0 ,tiendien =0 ,tnuoc =0 "
		+"where maph = '"+maphcu+"';";
	stmt.executeUpdate(sql);
	sql="update diennuoc set maph='"+maphmoi+"'where maph='"+maphcu+"';";
	stmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "successful");
    stmt.close();
    c.close();
	//stmt.executeQuery(sql);
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "failse in sql or instruct csdl");
	e.printStackTrace();
}
    }
}
