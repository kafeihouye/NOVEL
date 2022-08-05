package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.AuthorIncomeDetail;
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
public interface AuthorIncomeDetailMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(AuthorIncomeDetailDynamicSqlSupport.id, AuthorIncomeDetailDynamicSqlSupport.userId, AuthorIncomeDetailDynamicSqlSupport.authorId, AuthorIncomeDetailDynamicSqlSupport.bookId, AuthorIncomeDetailDynamicSqlSupport.incomeDate, AuthorIncomeDetailDynamicSqlSupport.incomeAccount, AuthorIncomeDetailDynamicSqlSupport.incomeCount, AuthorIncomeDetailDynamicSqlSupport.incomeNumber, AuthorIncomeDetailDynamicSqlSupport.createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AuthorIncomeDetail> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<AuthorIncomeDetail> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AuthorIncomeDetailResult")
    Optional<AuthorIncomeDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AuthorIncomeDetailResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="author_id", property="authorId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="income_date", property="incomeDate", jdbcType=JdbcType.DATE),
        @Result(column="income_account", property="incomeAccount", jdbcType=JdbcType.INTEGER),
        @Result(column="income_count", property="incomeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="income_number", property="incomeNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AuthorIncomeDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(AuthorIncomeDetailDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AuthorIncomeDetail record) {
        return MyBatis3Utils.insert(this::insert, record, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, c ->
            c.map(AuthorIncomeDetailDynamicSqlSupport.id).toProperty("id")
            .map(AuthorIncomeDetailDynamicSqlSupport.userId).toProperty("userId")
            .map(AuthorIncomeDetailDynamicSqlSupport.authorId).toProperty("authorId")
            .map(AuthorIncomeDetailDynamicSqlSupport.bookId).toProperty("bookId")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeDate).toProperty("incomeDate")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).toProperty("incomeAccount")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeCount).toProperty("incomeCount")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).toProperty("incomeNumber")
            .map(AuthorIncomeDetailDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<AuthorIncomeDetail> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, c ->
            c.map(AuthorIncomeDetailDynamicSqlSupport.id).toProperty("id")
            .map(AuthorIncomeDetailDynamicSqlSupport.userId).toProperty("userId")
            .map(AuthorIncomeDetailDynamicSqlSupport.authorId).toProperty("authorId")
            .map(AuthorIncomeDetailDynamicSqlSupport.bookId).toProperty("bookId")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeDate).toProperty("incomeDate")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).toProperty("incomeAccount")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeCount).toProperty("incomeCount")
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).toProperty("incomeNumber")
            .map(AuthorIncomeDetailDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AuthorIncomeDetail record) {
        return MyBatis3Utils.insert(this::insert, record, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, c ->
            c.map(AuthorIncomeDetailDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(AuthorIncomeDetailDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(AuthorIncomeDetailDynamicSqlSupport.authorId).toPropertyWhenPresent("authorId", record::getAuthorId)
            .map(AuthorIncomeDetailDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeDate).toPropertyWhenPresent("incomeDate", record::getIncomeDate)
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).toPropertyWhenPresent("incomeAccount", record::getIncomeAccount)
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeCount).toPropertyWhenPresent("incomeCount", record::getIncomeCount)
            .map(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).toPropertyWhenPresent("incomeNumber", record::getIncomeNumber)
            .map(AuthorIncomeDetailDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AuthorIncomeDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AuthorIncomeDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AuthorIncomeDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AuthorIncomeDetail> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(AuthorIncomeDetailDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, AuthorIncomeDetailDynamicSqlSupport.authorIncomeDetail, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AuthorIncomeDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(AuthorIncomeDetailDynamicSqlSupport.id).equalTo(record::getId)
                .set(AuthorIncomeDetailDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(AuthorIncomeDetailDynamicSqlSupport.authorId).equalTo(record::getAuthorId)
                .set(AuthorIncomeDetailDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeDate).equalTo(record::getIncomeDate)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).equalTo(record::getIncomeAccount)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeCount).equalTo(record::getIncomeCount)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).equalTo(record::getIncomeNumber)
                .set(AuthorIncomeDetailDynamicSqlSupport.createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AuthorIncomeDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(AuthorIncomeDetailDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(AuthorIncomeDetailDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(AuthorIncomeDetailDynamicSqlSupport.authorId).equalToWhenPresent(record::getAuthorId)
                .set(AuthorIncomeDetailDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeDate).equalToWhenPresent(record::getIncomeDate)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).equalToWhenPresent(record::getIncomeAccount)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeCount).equalToWhenPresent(record::getIncomeCount)
                .set(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).equalToWhenPresent(record::getIncomeNumber)
                .set(AuthorIncomeDetailDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AuthorIncomeDetail record) {
        return update(c ->
            c.set(AuthorIncomeDetailDynamicSqlSupport.userId).equalTo(record::getUserId)
            .set(AuthorIncomeDetailDynamicSqlSupport.authorId).equalTo(record::getAuthorId)
            .set(AuthorIncomeDetailDynamicSqlSupport.bookId).equalTo(record::getBookId)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeDate).equalTo(record::getIncomeDate)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).equalTo(record::getIncomeAccount)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeCount).equalTo(record::getIncomeCount)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).equalTo(record::getIncomeNumber)
            .set(AuthorIncomeDetailDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .where(AuthorIncomeDetailDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AuthorIncomeDetail record) {
        return update(c ->
            c.set(AuthorIncomeDetailDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
            .set(AuthorIncomeDetailDynamicSqlSupport.authorId).equalToWhenPresent(record::getAuthorId)
            .set(AuthorIncomeDetailDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeDate).equalToWhenPresent(record::getIncomeDate)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeAccount).equalToWhenPresent(record::getIncomeAccount)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeCount).equalToWhenPresent(record::getIncomeCount)
            .set(AuthorIncomeDetailDynamicSqlSupport.incomeNumber).equalToWhenPresent(record::getIncomeNumber)
            .set(AuthorIncomeDetailDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .where(AuthorIncomeDetailDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultType(value = Long.class)
    Long selectStatistic(SelectStatementProvider selectStatement);
}