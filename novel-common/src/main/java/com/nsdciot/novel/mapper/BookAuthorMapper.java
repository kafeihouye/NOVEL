package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.BookAuthor;
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
public interface BookAuthorMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(
        BookAuthorDynamicSqlSupport.id, BookAuthorDynamicSqlSupport.inviteCode, BookAuthorDynamicSqlSupport.penName, BookAuthorDynamicSqlSupport.telPhone, BookAuthorDynamicSqlSupport.chatAccount, BookAuthorDynamicSqlSupport.email, BookAuthorDynamicSqlSupport.workDirection, BookAuthorDynamicSqlSupport.status, BookAuthorDynamicSqlSupport.createTime, BookAuthorDynamicSqlSupport.createUserId, BookAuthorDynamicSqlSupport.updateTime, BookAuthorDynamicSqlSupport.updateUserId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookAuthor> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BookAuthor> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookAuthorResult")
    Optional<BookAuthor> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookAuthorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="invite_code", property="inviteCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="pen_name", property="penName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_phone", property="telPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="chat_account", property="chatAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_direction", property="workDirection", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookAuthor> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(BookAuthorDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookAuthor record) {
        return MyBatis3Utils.insert(this::insert, record, BookAuthorDynamicSqlSupport.bookAuthor, c ->
            c.map(BookAuthorDynamicSqlSupport.id).toProperty("id")
            .map(BookAuthorDynamicSqlSupport.inviteCode).toProperty("inviteCode")
            .map(BookAuthorDynamicSqlSupport.penName).toProperty("penName")
            .map(BookAuthorDynamicSqlSupport.telPhone).toProperty("telPhone")
            .map(BookAuthorDynamicSqlSupport.chatAccount).toProperty("chatAccount")
            .map(BookAuthorDynamicSqlSupport.email).toProperty("email")
            .map(BookAuthorDynamicSqlSupport.workDirection).toProperty("workDirection")
            .map(BookAuthorDynamicSqlSupport.status).toProperty("status")
            .map(BookAuthorDynamicSqlSupport.createTime).toProperty("createTime")
            .map(BookAuthorDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(BookAuthorDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(BookAuthorDynamicSqlSupport.updateUserId).toProperty("updateUserId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<BookAuthor> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, BookAuthorDynamicSqlSupport.bookAuthor, c ->
            c.map(BookAuthorDynamicSqlSupport.id).toProperty("id")
            .map(BookAuthorDynamicSqlSupport.inviteCode).toProperty("inviteCode")
            .map(BookAuthorDynamicSqlSupport.penName).toProperty("penName")
            .map(BookAuthorDynamicSqlSupport.telPhone).toProperty("telPhone")
            .map(BookAuthorDynamicSqlSupport.chatAccount).toProperty("chatAccount")
            .map(BookAuthorDynamicSqlSupport.email).toProperty("email")
            .map(BookAuthorDynamicSqlSupport.workDirection).toProperty("workDirection")
            .map(BookAuthorDynamicSqlSupport.status).toProperty("status")
            .map(BookAuthorDynamicSqlSupport.createTime).toProperty("createTime")
            .map(BookAuthorDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(BookAuthorDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(BookAuthorDynamicSqlSupport.updateUserId).toProperty("updateUserId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookAuthor record) {
        return MyBatis3Utils.insert(this::insert, record, BookAuthorDynamicSqlSupport.bookAuthor, c ->
            c.map(BookAuthorDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(BookAuthorDynamicSqlSupport.inviteCode).toPropertyWhenPresent("inviteCode", record::getInviteCode)
            .map(BookAuthorDynamicSqlSupport.penName).toPropertyWhenPresent("penName", record::getPenName)
            .map(BookAuthorDynamicSqlSupport.telPhone).toPropertyWhenPresent("telPhone", record::getTelPhone)
            .map(BookAuthorDynamicSqlSupport.chatAccount).toPropertyWhenPresent("chatAccount", record::getChatAccount)
            .map(BookAuthorDynamicSqlSupport.email).toPropertyWhenPresent("email", record::getEmail)
            .map(BookAuthorDynamicSqlSupport.workDirection).toPropertyWhenPresent("workDirection", record::getWorkDirection)
            .map(BookAuthorDynamicSqlSupport.status).toPropertyWhenPresent("status", record::getStatus)
            .map(BookAuthorDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(BookAuthorDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
            .map(BookAuthorDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(BookAuthorDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookAuthor> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookAuthor> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookAuthor> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookAuthor> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(BookAuthorDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, BookAuthorDynamicSqlSupport.bookAuthor, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(BookAuthor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookAuthorDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookAuthorDynamicSqlSupport.inviteCode).equalTo(record::getInviteCode)
                .set(BookAuthorDynamicSqlSupport.penName).equalTo(record::getPenName)
                .set(BookAuthorDynamicSqlSupport.telPhone).equalTo(record::getTelPhone)
                .set(BookAuthorDynamicSqlSupport.chatAccount).equalTo(record::getChatAccount)
                .set(BookAuthorDynamicSqlSupport.email).equalTo(record::getEmail)
                .set(BookAuthorDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
                .set(BookAuthorDynamicSqlSupport.status).equalTo(record::getStatus)
                .set(BookAuthorDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookAuthorDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(BookAuthorDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(BookAuthorDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(BookAuthor record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookAuthorDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookAuthorDynamicSqlSupport.inviteCode).equalToWhenPresent(record::getInviteCode)
                .set(BookAuthorDynamicSqlSupport.penName).equalToWhenPresent(record::getPenName)
                .set(BookAuthorDynamicSqlSupport.telPhone).equalToWhenPresent(record::getTelPhone)
                .set(BookAuthorDynamicSqlSupport.chatAccount).equalToWhenPresent(record::getChatAccount)
                .set(BookAuthorDynamicSqlSupport.email).equalToWhenPresent(record::getEmail)
                .set(BookAuthorDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(BookAuthorDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                .set(BookAuthorDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookAuthorDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(BookAuthorDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(BookAuthorDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookAuthor record) {
        return update(c ->
            c.set(BookAuthorDynamicSqlSupport.inviteCode).equalTo(record::getInviteCode)
            .set(BookAuthorDynamicSqlSupport.penName).equalTo(record::getPenName)
            .set(BookAuthorDynamicSqlSupport.telPhone).equalTo(record::getTelPhone)
            .set(BookAuthorDynamicSqlSupport.chatAccount).equalTo(record::getChatAccount)
            .set(BookAuthorDynamicSqlSupport.email).equalTo(record::getEmail)
            .set(BookAuthorDynamicSqlSupport.workDirection).equalTo(record::getWorkDirection)
            .set(BookAuthorDynamicSqlSupport.status).equalTo(record::getStatus)
            .set(BookAuthorDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(BookAuthorDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
            .set(BookAuthorDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .set(BookAuthorDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
            .where(BookAuthorDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookAuthor record) {
        return update(c ->
            c.set(BookAuthorDynamicSqlSupport.inviteCode).equalToWhenPresent(record::getInviteCode)
            .set(BookAuthorDynamicSqlSupport.penName).equalToWhenPresent(record::getPenName)
            .set(BookAuthorDynamicSqlSupport.telPhone).equalToWhenPresent(record::getTelPhone)
            .set(BookAuthorDynamicSqlSupport.chatAccount).equalToWhenPresent(record::getChatAccount)
            .set(BookAuthorDynamicSqlSupport.email).equalToWhenPresent(record::getEmail)
            .set(BookAuthorDynamicSqlSupport.workDirection).equalToWhenPresent(record::getWorkDirection)
            .set(BookAuthorDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
            .set(BookAuthorDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(BookAuthorDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
            .set(BookAuthorDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(BookAuthorDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
            .where(BookAuthorDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}