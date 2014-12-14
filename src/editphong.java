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
    public editphong(int khu,String loaicu,String loaiphmoi,String maph_cu,String maph_moi)
    {  int songuoi;
    songuoi=0;
        try {
	Statement stmt =c.createStatement();
	String sql="update phong set ma_nha='"+khu+"',songuoi='"+songuoi+"',maph='"+maph_moi+"',loai_ph='"+loaiphmoi+"' where ma_nha='"+khu+"'and maph='"+maph_cu+"' and loai_ph='"+loaicu+"';";			
	stmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "successful");
    stmt.close();
    c.close();
	//stmt.executeQuery(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    }
}
