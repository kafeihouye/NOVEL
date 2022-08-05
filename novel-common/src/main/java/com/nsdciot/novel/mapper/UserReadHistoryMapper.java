package com.nsdciot.novel.mapper;

import com.nsdciot.novel.entity.UserReadHistory;
import org.apache.ibatis.annotations.*;
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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface UserReadHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(UserReadHistoryDynamicSqlSupport.id, UserReadHistoryDynamicSqlSupport.userId, UserReadHistoryDynamicSqlSupport.bookId, UserReadHistoryDynamicSqlSupport.preContentId, UserReadHistoryDynamicSqlSupport.createTime, UserReadHistoryDynamicSqlSupport.updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserReadHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserReadHistory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserReadHistoryResult")
    Optional<UserReadHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserReadHistoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="pre_content_id", property="preContentId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserReadHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(UserReadHistoryDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserReadHistory record) {
        return MyBatis3Utils.insert(this::insert, record, UserReadHistoryDynamicSqlSupport.userReadHistory, c ->
            c.map(UserReadHistoryDynamicSqlSupport.id).toProperty("id")
            .map(UserReadHistoryDynamicSqlSupport.userId).toProperty("userId")
            .map(UserReadHistoryDynamicSqlSupport.bookId).toProperty("bookId")
            .map(UserReadHistoryDynamicSqlSupport.preContentId).toProperty("preContentId")
            .map(UserReadHistoryDynamicSqlSupport.createTime).toProperty("createTime")
            .map(UserReadHistoryDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<UserReadHistory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, UserReadHistoryDynamicSqlSupport.userReadHistory, c ->
            c.map(UserReadHistoryDynamicSqlSupport.id).toProperty("id")
            .map(UserReadHistoryDynamicSqlSupport.userId).toProperty("userId")
            .map(UserReadHistoryDynamicSqlSupport.bookId).toProperty("bookId")
            .map(UserReadHistoryDynamicSqlSupport.preContentId).toProperty("preContentId")
            .map(UserReadHistoryDynamicSqlSupport.createTime).toProperty("createTime")
            .map(UserReadHistoryDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserReadHistory record) {
        return MyBatis3Utils.insert(this::insert, record, UserReadHistoryDynamicSqlSupport.userReadHistory, c ->
            c.map(UserReadHistoryDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(UserReadHistoryDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(UserReadHistoryDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
            .map(UserReadHistoryDynamicSqlSupport.preContentId).toPropertyWhenPresent("preContentId", record::getPreContentId)
            .map(UserReadHistoryDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(UserReadHistoryDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserReadHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserReadHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserReadHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserReadHistory> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(UserReadHistoryDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, UserReadHistoryDynamicSqlSupport.userReadHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UserReadHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserReadHistoryDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserReadHistoryDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserReadHistoryDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(UserReadHistoryDynamicSqlSupport.preContentId).equalTo(record::getPreContentId)
                .set(UserReadHistoryDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(UserReadHistoryDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserReadHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserReadHistoryDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserReadHistoryDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserReadHistoryDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(UserReadHistoryDynamicSqlSupport.preContentId).equalToWhenPresent(record::getPreContentId)
                .set(UserReadHistoryDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(UserReadHistoryDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserReadHistory record) {
        return update(c ->
            c.set(UserReadHistoryDynamicSqlSupport.userId).equalTo(record::getUserId)
            .set(UserReadHistoryDynamicSqlSupport.bookId).equalTo(record::getBookId)
            .set(UserReadHistoryDynamicSqlSupport.preContentId).equalTo(record::getPreContentId)
            .set(UserReadHistoryDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(UserReadHistoryDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .where(UserReadHistoryDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserReadHistory record) {
        return update(c ->
            c.set(UserReadHistoryDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
            .set(UserReadHistoryDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
            .set(UserReadHistoryDynamicSqlSupport.preContentId).equalToWhenPresent(record::getPreContentId)
            .set(UserReadHistoryDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(UserReadHistoryDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(UserReadHistoryDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

}