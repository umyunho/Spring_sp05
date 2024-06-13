package com.himedia.sp05.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Dbman {

    @Autowired
    DbConInfo dbconinfo;

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(dbconinfo.getDriver());
            con = DriverManager.getConnection(dbconinfo.getUrl(), dbconinfo.getId(),dbconinfo.getPw());
        } catch (ClassNotFoundException e) {e.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
        return con;
    }
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try{
            if(con!=null)con.close();
            if(pstmt!=null)pstmt.close();
            if(rs!=null)rs.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


