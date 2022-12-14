package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.BookContent;
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
public interface BookContentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(
        BookContentDynamicSqlSupport.id, BookContentDynamicSqlSupport.indexId, BookContentDynamicSqlSupport.content);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookContent> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BookContent> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookContentResult")
    Optional<BookContent> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookContentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="index_id", property="indexId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR)
    })
    List<BookContent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(BookContentDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookContent record) {
        return MyBatis3Utils.insert(this::insert, record, BookContentDynamicSqlSupport.bookContent, c ->
            c.map(BookContentDynamicSqlSupport.id).toProperty("id")
            .map(BookContentDynamicSqlSupport.indexId).toProperty("indexId")
            .map(BookContentDynamicSqlSupport.content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<BookContent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, BookContentDynamicSqlSupport.bookContent, c ->
            c.map(BookContentDynamicSqlSupport.id).toProperty("id")
            .map(BookContentDynamicSqlSupport.indexId).toProperty("indexId")
            .map(BookContentDynamicSqlSupport.content).toProperty("content")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookContent record) {
        return MyBatis3Utils.insert(this::insert, record, BookContentDynamicSqlSupport.bookContent, c ->
            c.map(BookContentDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(BookContentDynamicSqlSupport.indexId).toPropertyWhenPresent("indexId", record::getIndexId)
            .map(BookContentDynamicSqlSupport.content).toPropertyWhenPresent("content", record::getContent)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookContent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookContent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookContent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookContent> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(BookContentDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, BookContentDynamicSqlSupport.bookContent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(BookContent record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookContentDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookContentDynamicSqlSupport.indexId).equalTo(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalTo(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(BookContent record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookContentDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookContentDynamicSqlSupport.indexId).equalToWhenPresent(record::getIndexId)
                .set(BookContentDynamicSqlSupport.content).equalToWhenPresent(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookContent record) {
        return update(c ->
            c.set(BookContentDynamicSqlSupport.indexId).equalTo(record::getIndexId)
            .set(BookContentDynamicSqlSupport.content).equalTo(record::getContent)
            .where(BookContentDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookContent record) {
        return update(c ->
            c.set(BookContentDynamicSqlSupport.indexId).equalToWhenPresent(record::getIndexId)
            .set(BookContentDynamicSqlSupport.content).equalToWhenPresent(record::getContent)
            .where(BookContentDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}