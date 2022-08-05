package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

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

@Mapper
public interface UserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.password, UserDynamicSqlSupport.nickName, UserDynamicSqlSupport.userPhoto, UserDynamicSqlSupport.userSex, UserDynamicSqlSupport.accountBalance, UserDynamicSqlSupport.status, UserDynamicSqlSupport.createTime, UserDynamicSqlSupport.updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_photo", property="userPhoto", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.TINYINT),
        @Result(column="account_balance", property="accountBalance", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(UserDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, UserDynamicSqlSupport.user, c ->
            c.map(UserDynamicSqlSupport.id).toProperty("id")
            .map(UserDynamicSqlSupport.username).toProperty("username")
            .map(UserDynamicSqlSupport.password).toProperty("password")
            .map(UserDynamicSqlSupport.nickName).toProperty("nickName")
            .map(UserDynamicSqlSupport.userPhoto).toProperty("userPhoto")
            .map(UserDynamicSqlSupport.userSex).toProperty("userSex")
            .map(UserDynamicSqlSupport.accountBalance).toProperty("accountBalance")
            .map(UserDynamicSqlSupport.status).toProperty("status")
            .map(UserDynamicSqlSupport.createTime).toProperty("createTime")
            .map(UserDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, UserDynamicSqlSupport.user, c ->
            c.map(UserDynamicSqlSupport.id).toProperty("id")
            .map(UserDynamicSqlSupport.username).toProperty("username")
            .map(UserDynamicSqlSupport.password).toProperty("password")
            .map(UserDynamicSqlSupport.nickName).toProperty("nickName")
            .map(UserDynamicSqlSupport.userPhoto).toProperty("userPhoto")
            .map(UserDynamicSqlSupport.userSex).toProperty("userSex")
            .map(UserDynamicSqlSupport.accountBalance).toProperty("accountBalance")
            .map(UserDynamicSqlSupport.status).toProperty("status")
            .map(UserDynamicSqlSupport.createTime).toProperty("createTime")
            .map(UserDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, UserDynamicSqlSupport.user, c ->
            c.map(UserDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(UserDynamicSqlSupport.username).toPropertyWhenPresent("username", record::getUsername)
            .map(UserDynamicSqlSupport.password).toPropertyWhenPresent("password", record::getPassword)
            .map(UserDynamicSqlSupport.nickName).toPropertyWhenPresent("nickName", record::getNickName)
            .map(UserDynamicSqlSupport.userPhoto).toPropertyWhenPresent("userPhoto", record::getUserPhoto)
            .map(UserDynamicSqlSupport.userSex).toPropertyWhenPresent("userSex", record::getUserSex)
            .map(UserDynamicSqlSupport.accountBalance).toPropertyWhenPresent("accountBalance", record::getAccountBalance)
            .map(UserDynamicSqlSupport.status).toPropertyWhenPresent("status", record::getStatus)
            .map(UserDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(UserDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(UserDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, UserDynamicSqlSupport.user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserDynamicSqlSupport.username).equalTo(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalTo(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalTo(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalTo(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalTo(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalTo(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalTo(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
                .set(UserDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
                .set(UserDynamicSqlSupport.nickName).equalToWhenPresent(record::getNickName)
                .set(UserDynamicSqlSupport.userPhoto).equalToWhenPresent(record::getUserPhoto)
                .set(UserDynamicSqlSupport.userSex).equalToWhenPresent(record::getUserSex)
                .set(UserDynamicSqlSupport.accountBalance).equalToWhenPresent(record::getAccountBalance)
                .set(UserDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
                .set(UserDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(UserDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(UserDynamicSqlSupport.username).equalTo(record::getUsername)
            .set(UserDynamicSqlSupport.password).equalTo(record::getPassword)
            .set(UserDynamicSqlSupport.nickName).equalTo(record::getNickName)
            .set(UserDynamicSqlSupport.userPhoto).equalTo(record::getUserPhoto)
            .set(UserDynamicSqlSupport.userSex).equalTo(record::getUserSex)
            .set(UserDynamicSqlSupport.accountBalance).equalTo(record::getAccountBalance)
            .set(UserDynamicSqlSupport.status).equalTo(record::getStatus)
            .set(UserDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(UserDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .where(UserDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(UserDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
            .set(UserDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
            .set(UserDynamicSqlSupport.nickName).equalToWhenPresent(record::getNickName)
            .set(UserDynamicSqlSupport.userPhoto).equalToWhenPresent(record::getUserPhoto)
            .set(UserDynamicSqlSupport.userSex).equalToWhenPresent(record::getUserSex)
            .set(UserDynamicSqlSupport.accountBalance).equalToWhenPresent(record::getAccountBalance)
            .set(UserDynamicSqlSupport.status).equalToWhenPresent(record::getStatus)
            .set(UserDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(UserDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(UserDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultType(value = Integer.class)
    Integer selectStatistic(SelectStatementProvider selectStatement);
}