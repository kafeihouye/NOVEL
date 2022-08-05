package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.UserBuyRecord;
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
public interface UserBuyRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(
        UserBuyRecordDynamicSqlSupport.id, UserBuyRecordDynamicSqlSupport.userId, UserBuyRecordDynamicSqlSupport.bookId, UserBuyRecordDynamicSqlSupport.bookName, UserBuyRecordDynamicSqlSupport.bookIndexId, UserBuyRecordDynamicSqlSupport.bookIndexName, UserBuyRecordDynamicSqlSupport.buyAmount, UserBuyRecordDynamicSqlSupport.createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserBuyRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserBuyRecord> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserBuyRecordResult")
    Optional<UserBuyRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserBuyRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_index_id", property="bookIndexId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_index_name", property="bookIndexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_amount", property="buyAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserBuyRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserBuyRecord record) {
        return MyBatis3Utils.insert(this::insert, record, UserBuyRecordDynamicSqlSupport.userBuyRecord, c ->
            c.map(UserBuyRecordDynamicSqlSupport.id).toProperty("id")
            .map(UserBuyRecordDynamicSqlSupport.userId).toProperty("userId")
            .map(UserBuyRecordDynamicSqlSupport.bookId).toProperty("bookId")
            .map(UserBuyRecordDynamicSqlSupport.bookName).toProperty("bookName")
            .map(UserBuyRecordDynamicSqlSupport.bookIndexId).toProperty("bookIndexId")
            .map(UserBuyRecordDynamicSqlSupport.bookIndexName).toProperty("bookIndexName")
            .map(UserBuyRecordDynamicSqlSupport.buyAmount).toProperty("buyAmount")
            .map(UserBuyRecordDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<UserBuyRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, UserBuyRecordDynamicSqlSupport.userBuyRecord, c ->
            c.map(UserBuyRecordDynamicSqlSupport.id).toProperty("id")
            .map(UserBuyRecordDynamicSqlSupport.userId).toProperty("userId")
            .map(UserBuyRecordDynamicSqlSupport.bookId).toProperty("bookId")
            .map(UserBuyRecordDynamicSqlSupport.bookName).toProperty("bookName")
            .map(UserBuyRecordDynamicSqlSupport.bookIndexId).toProperty("bookIndexId")
            .map(UserBuyRecordDynamicSqlSupport.bookIndexName).toProperty("bookIndexName")
            .map(UserBuyRecordDynamicSqlSupport.buyAmount).toProperty("buyAmount")
            .map(UserBuyRecordDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserBuyRecord record) {
        return MyBatis3Utils.insert(this::insert, record, UserBuyRecordDynamicSqlSupport.userBuyRecord, c ->
            c.map(UserBuyRecordDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(UserBuyRecordDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(UserBuyRecordDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
            .map(UserBuyRecordDynamicSqlSupport.bookName).toPropertyWhenPresent("bookName", record::getBookName)
            .map(UserBuyRecordDynamicSqlSupport.bookIndexId).toPropertyWhenPresent("bookIndexId", record::getBookIndexId)
            .map(UserBuyRecordDynamicSqlSupport.bookIndexName).toPropertyWhenPresent("bookIndexName", record::getBookIndexName)
            .map(UserBuyRecordDynamicSqlSupport.buyAmount).toPropertyWhenPresent("buyAmount", record::getBuyAmount)
            .map(UserBuyRecordDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserBuyRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserBuyRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<UserBuyRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<UserBuyRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, UserBuyRecordDynamicSqlSupport.userBuyRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(UserBuyRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserBuyRecordDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalTo(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalTo(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalTo(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalTo(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserBuyRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserBuyRecordDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserBuyRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(UserBuyRecordDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(UserBuyRecordDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalToWhenPresent(record::getBookIndexId)
                .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalToWhenPresent(record::getBookIndexName)
                .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalToWhenPresent(record::getBuyAmount)
                .set(UserBuyRecordDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserBuyRecord record) {
        return update(c ->
            c.set(UserBuyRecordDynamicSqlSupport.userId).equalTo(record::getUserId)
            .set(UserBuyRecordDynamicSqlSupport.bookId).equalTo(record::getBookId)
            .set(UserBuyRecordDynamicSqlSupport.bookName).equalTo(record::getBookName)
            .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalTo(record::getBookIndexId)
            .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalTo(record::getBookIndexName)
            .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalTo(record::getBuyAmount)
            .set(UserBuyRecordDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserBuyRecord record) {
        return update(c ->
            c.set(UserBuyRecordDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
            .set(UserBuyRecordDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
            .set(UserBuyRecordDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
            .set(UserBuyRecordDynamicSqlSupport.bookIndexId).equalToWhenPresent(record::getBookIndexId)
            .set(UserBuyRecordDynamicSqlSupport.bookIndexName).equalToWhenPresent(record::getBookIndexName)
            .set(UserBuyRecordDynamicSqlSupport.buyAmount).equalToWhenPresent(record::getBuyAmount)
            .set(UserBuyRecordDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .where(UserBuyRecordDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}