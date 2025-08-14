package com.news.auth.libs;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.news.auth.dto.userDto;

@Repository
@RequiredArgsConstructor
public class database {
    private final SqlSessionTemplate sql;

    public void save(String nameSpace,String queryId,userDto params){
        System.out.println(nameSpace+"."+queryId);
        System.out.println(params);
         sql.insert(nameSpace+"."+queryId,params);
//        sql.insert("authMappers.joins",params);
    }
//    public Object view(String nameSpace,String queryId, Object params){
//        return sql.selectOne(nameSpace+"."+queryId,params);
//    }

}
