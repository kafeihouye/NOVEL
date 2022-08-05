package com.nsdciot.novel.mapper;

import com.nsdciot.novel.entity.BookSetting;
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
public interface BookSettingMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(
        BookSettingDynamicSqlSupport.id, BookSettingDynamicSqlSupport.bookId, BookSettingDynamicSqlSupport.sort, BookSettingDynamicSqlSupport.type, BookSettingDynamicSqlSupport.createTime, BookSettingDynamicSqlSupport.createUserId, BookSettingDynamicSqlSupport.updateTime, BookSettingDynamicSqlSupport.updateUserId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookSetting> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BookSetting> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookSettingResult")
    Optional<BookSetting> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookSettingResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookSetting> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(BookSettingDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookSetting record) {
        return MyBatis3Utils.insert(this::insert, record, BookSettingDynamicSqlSupport.bookSetting, c ->
            c.map(BookSettingDynamicSqlSupport.id).toProperty("id")
            .map(BookSettingDynamicSqlSupport.bookId).toProperty("bookId")
            .map(BookSettingDynamicSqlSupport.sort).toProperty("sort")
            .map(BookSettingDynamicSqlSupport.type).toProperty("type")
            .map(BookSettingDynamicSqlSupport.createTime).toProperty("createTime")
            .map(BookSettingDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(BookSettingDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(BookSettingDynamicSqlSupport.updateUserId).toProperty("updateUserId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<BookSetting> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, BookSettingDynamicSqlSupport.bookSetting, c ->
            c.map(BookSettingDynamicSqlSupport.id).toProperty("id")
            .map(BookSettingDynamicSqlSupport.bookId).toProperty("bookId")
            .map(BookSettingDynamicSqlSupport.sort).toProperty("sort")
            .map(BookSettingDynamicSqlSupport.type).toProperty("type")
            .map(BookSettingDynamicSqlSupport.createTime).toProperty("createTime")
            .map(BookSettingDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(BookSettingDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(BookSettingDynamicSqlSupport.updateUserId).toProperty("updateUserId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookSetting record) {
        return MyBatis3Utils.insert(this::insert, record, BookSettingDynamicSqlSupport.bookSetting, c ->
            c.map(BookSettingDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(BookSettingDynamicSqlSupport.bookId).toPropertyWhenPresent("bookId", record::getBookId)
            .map(BookSettingDynamicSqlSupport.sort).toPropertyWhenPresent("sort", record::getSort)
            .map(BookSettingDynamicSqlSupport.type).toPropertyWhenPresent("type", record::getType)
            .map(BookSettingDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(BookSettingDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
            .map(BookSettingDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(BookSettingDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookSetting> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookSetting> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<BookSetting> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<BookSetting> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(BookSettingDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, BookSettingDynamicSqlSupport.bookSetting, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(BookSetting record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookSettingDynamicSqlSupport.id).equalTo(record::getId)
                .set(BookSettingDynamicSqlSupport.bookId).equalTo(record::getBookId)
                .set(BookSettingDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(BookSettingDynamicSqlSupport.type).equalTo(record::getType)
                .set(BookSettingDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(BookSettingDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(BookSettingDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(BookSettingDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(BookSetting record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(BookSettingDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(BookSettingDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
                .set(BookSettingDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(BookSettingDynamicSqlSupport.type).equalToWhenPresent(record::getType)
                .set(BookSettingDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(BookSettingDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(BookSettingDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(BookSettingDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookSetting record) {
        return update(c ->
            c.set(BookSettingDynamicSqlSupport.bookId).equalTo(record::getBookId)
            .set(BookSettingDynamicSqlSupport.sort).equalTo(record::getSort)
            .set(BookSettingDynamicSqlSupport.type).equalTo(record::getType)
            .set(BookSettingDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(BookSettingDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
            .set(BookSettingDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .set(BookSettingDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
            .where(BookSettingDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookSetting record) {
        return update(c ->
            c.set(BookSettingDynamicSqlSupport.bookId).equalToWhenPresent(record::getBookId)
            .set(BookSettingDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
            .set(BookSettingDynamicSqlSupport.type).equalToWhenPresent(record::getType)
            .set(BookSettingDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(BookSettingDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
            .set(BookSettingDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(BookSettingDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
            .where(BookSettingDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }


}