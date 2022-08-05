package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.News;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface NewsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(NewsDynamicSqlSupport.id, NewsDynamicSqlSupport.catId, NewsDynamicSqlSupport.catName, NewsDynamicSqlSupport.sourceName, NewsDynamicSqlSupport.title, NewsDynamicSqlSupport.readCount, NewsDynamicSqlSupport.createTime, NewsDynamicSqlSupport.createUserId, NewsDynamicSqlSupport.updateTime, NewsDynamicSqlSupport.updateUserId, NewsDynamicSqlSupport.content);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<News> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<News> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NewsResult")
    Optional<News> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NewsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER),
        @Result(column="cat_name", property="catName", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_name", property="sourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<News> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(NewsDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(News record) {
        return MyBatis3Utils.insert(this::insert, record, NewsDynamicSqlSupport.news, c ->
            c.map(NewsDynamicSqlSupport.id).toProperty("id")
            .map(NewsDynamicSqlSupport.catId).toProperty("catId")
            .map(NewsDynamicSqlSupport.catName).toProperty("catName")
            .map(NewsDynamicSqlSupport.sourceName).toProperty("sourceName")
            .map(NewsDynamicSqlSupport.title).toProperty("title")
            .map(NewsDynamicSqlSupport.readCount).toProperty("readCount")
            .map(NewsDynamicSqlSupport.createTime).toProperty("createTime")
            .map(NewsDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(NewsDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(NewsDynamicSqlSupport.updateUserId).toProperty("updateUserId")
            .map(NewsDynamicSqlSupport.content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<News> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, NewsDynamicSqlSupport.news, c ->
            c.map(NewsDynamicSqlSupport.id).toProperty("id")
            .map(NewsDynamicSqlSupport.catId).toProperty("catId")
            .map(NewsDynamicSqlSupport.catName).toProperty("catName")
            .map(NewsDynamicSqlSupport.sourceName).toProperty("sourceName")
            .map(NewsDynamicSqlSupport.title).toProperty("title")
            .map(NewsDynamicSqlSupport.readCount).toProperty("readCount")
            .map(NewsDynamicSqlSupport.createTime).toProperty("createTime")
            .map(NewsDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(NewsDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(NewsDynamicSqlSupport.updateUserId).toProperty("updateUserId")
            .map(NewsDynamicSqlSupport.content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(News record) {
        return MyBatis3Utils.insert(this::insert, record, NewsDynamicSqlSupport.news, c ->
            c.map(NewsDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(NewsDynamicSqlSupport.catId).toPropertyWhenPresent("catId", record::getCatId)
            .map(NewsDynamicSqlSupport.catName).toPropertyWhenPresent("catName", record::getCatName)
            .map(NewsDynamicSqlSupport.sourceName).toPropertyWhenPresent("sourceName", record::getSourceName)
            .map(NewsDynamicSqlSupport.title).toPropertyWhenPresent("title", record::getTitle)
            .map(NewsDynamicSqlSupport.readCount).toPropertyWhenPresent("readCount", record::getReadCount)
            .map(NewsDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(NewsDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
            .map(NewsDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(NewsDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
            .map(NewsDynamicSqlSupport.content).toPropertyWhenPresent("content", record::getContent)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<News> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<News> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<News> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<News> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(NewsDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, NewsDynamicSqlSupport.news, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(News record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(NewsDynamicSqlSupport.id).equalTo(record::getId)
                .set(NewsDynamicSqlSupport.catId).equalTo(record::getCatId)
                .set(NewsDynamicSqlSupport.catName).equalTo(record::getCatName)
                .set(NewsDynamicSqlSupport.sourceName).equalTo(record::getSourceName)
                .set(NewsDynamicSqlSupport.title).equalTo(record::getTitle)
                .set(NewsDynamicSqlSupport.readCount).equalTo(record::getReadCount)
                .set(NewsDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(NewsDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(NewsDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(NewsDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(NewsDynamicSqlSupport.content).equalTo(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(News record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(NewsDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(NewsDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
                .set(NewsDynamicSqlSupport.catName).equalToWhenPresent(record::getCatName)
                .set(NewsDynamicSqlSupport.sourceName).equalToWhenPresent(record::getSourceName)
                .set(NewsDynamicSqlSupport.title).equalToWhenPresent(record::getTitle)
                .set(NewsDynamicSqlSupport.readCount).equalToWhenPresent(record::getReadCount)
                .set(NewsDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(NewsDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(NewsDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(NewsDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(NewsDynamicSqlSupport.content).equalToWhenPresent(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(News record) {
        return update(c ->
            c.set(NewsDynamicSqlSupport.catId).equalTo(record::getCatId)
            .set(NewsDynamicSqlSupport.catName).equalTo(record::getCatName)
            .set(NewsDynamicSqlSupport.sourceName).equalTo(record::getSourceName)
            .set(NewsDynamicSqlSupport.title).equalTo(record::getTitle)
            .set(NewsDynamicSqlSupport.readCount).equalTo(record::getReadCount)
            .set(NewsDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(NewsDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
            .set(NewsDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .set(NewsDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
            .set(NewsDynamicSqlSupport.content).equalTo(record::getContent)
            .where(NewsDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(News record) {
        return update(c ->
            c.set(NewsDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
            .set(NewsDynamicSqlSupport.catName).equalToWhenPresent(record::getCatName)
            .set(NewsDynamicSqlSupport.sourceName).equalToWhenPresent(record::getSourceName)
            .set(NewsDynamicSqlSupport.title).equalToWhenPresent(record::getTitle)
            .set(NewsDynamicSqlSupport.readCount).equalToWhenPresent(record::getReadCount)
            .set(NewsDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(NewsDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
            .set(NewsDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(NewsDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
            .set(NewsDynamicSqlSupport.content).equalToWhenPresent(record::getContent)
            .where(NewsDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}