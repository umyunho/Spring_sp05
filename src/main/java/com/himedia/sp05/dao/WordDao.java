package com.himedia.sp05.dao;

import com.himedia.sp05.dto.WordDto;
import com.himedia.sp05.util.Dbman;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WordDao {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Autowired
    Dbman dbman;


    public void insertWord(WordDto wdto) {
        String sql= "insert into wordset values(? , ?)";
        con = dbman.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, wdto.getWordKey());
            pstmt.setString(2, wdto.getWordValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbman.close(con,pstmt,rs);
        }
    }

    public ArrayList<WordDto> seleceWord() {
        ArrayList<WordDto> list = new ArrayList<WordDto>();
        String sql="select * from wordset";
        con = dbman.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                WordDto wtd = new WordDto(
                        rs.getString("wordKey"),
                        rs.getString("wordValue")
                );
                list.add(wtd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbman.close(con, pstmt, rs);
        }
        return list;
    }

    public WordDto searchWord(String input) {
        WordDto wdto = null;
        String sql= "select * from wordset where wordkey=?";
        con = dbman.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, input);
            rs = pstmt.executeQuery();
            if(rs.next()){
                wdto = new WordDto();
                wdto.setWordKey(rs.getString("wordKey"));
                wdto.setWordValue(rs.getString("wordValue"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbman.close(con, pstmt, rs);
        }
        return wdto;
    }
}



























