package com.news.auth.libs;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.news.auth.dto.userDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class database {
    private final SqlSessionTemplate sql;

    public void save(String nameSpace, String queryId, Object params) {
        sql.insert(nameSpace + "." + queryId, params);
    }

    public Object view(String nameSpace, String queryId, Object params) {
        return sql.selectOne(nameSpace + "." + queryId, params);
    }

    public List<Object> list(String nameSpace, String queryId, Object params) {
        return sql.selectList(nameSpace + "." + queryId, params);
    }

    public void update(String nameSpace, String queryId, Object params) {
        sql.update(nameSpace + "." + queryId, params);
    }

}
