package com.gzz.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.gzz.entity.Book;

import java.util.List;
 
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    /**
     * 直接构建查询语句查询
     *
     * @param searchContent 内容
     * @return 查询结果
     */
    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"should\": [\n" +
            "        {\n" +
            "          \"match_phrase\": {\n" +
            "            \"name\": {\n" +
            "              \"query\": \"?0\",\n" +
            "              \"boost\": 3\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"match_phrase\": {\n" +
            "            \"author\": {\n" +
            "              \"query\": \"?0\",\n" +
            "              \"boost\": 2\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"match_phrase\": {\n" +
            "            \"description\": {\n" +
            "              \"query\": \"?0\",\n" +
            "              \"boost\": 1\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "}")
    List<Book> searchBook(String searchContent);

    /**
     * 根据书籍名称查询
     *
     * @param name 姓
     * @return 结果
     */
    List<Book> findByName(String name);

}