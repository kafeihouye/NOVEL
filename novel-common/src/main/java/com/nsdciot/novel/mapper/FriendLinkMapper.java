package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.FriendLink;
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
public interface FriendLinkMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(
        FriendLinkDynamicSqlSupport.id, FriendLinkDynamicSqlSupport.linkName, FriendLinkDynamicSqlSupport.linkUrl, FriendLinkDynamicSqlSupport.sort, FriendLinkDynamicSqlSupport.isOpen, FriendLinkDynamicSqlSupport.createUserId, FriendLinkDynamicSqlSupport.createTime, FriendLinkDynamicSqlSupport.updateUserId, FriendLinkDynamicSqlSupport.updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FriendLink> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<FriendLink> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FriendLinkResult")
    Optional<FriendLink> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FriendLinkResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="link_name", property="linkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_url", property="linkUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="is_open", property="isOpen", jdbcType=JdbcType.TINYINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FriendLink> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(FriendLinkDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(FriendLink record) {
        return MyBatis3Utils.insert(this::insert, record, FriendLinkDynamicSqlSupport.friendLink, c ->
            c.map(FriendLinkDynamicSqlSupport.id).toProperty("id")
            .map(FriendLinkDynamicSqlSupport.linkName).toProperty("linkName")
            .map(FriendLinkDynamicSqlSupport.linkUrl).toProperty("linkUrl")
            .map(FriendLinkDynamicSqlSupport.sort).toProperty("sort")
            .map(FriendLinkDynamicSqlSupport.isOpen).toProperty("isOpen")
            .map(FriendLinkDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(FriendLinkDynamicSqlSupport.createTime).toProperty("createTime")
            .map(FriendLinkDynamicSqlSupport.updateUserId).toProperty("updateUserId")
            .map(FriendLinkDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<FriendLink> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, FriendLinkDynamicSqlSupport.friendLink, c ->
            c.map(FriendLinkDynamicSqlSupport.id).toProperty("id")
            .map(FriendLinkDynamicSqlSupport.linkName).toProperty("linkName")
            .map(FriendLinkDynamicSqlSupport.linkUrl).toProperty("linkUrl")
            .map(FriendLinkDynamicSqlSupport.sort).toProperty("sort")
            .map(FriendLinkDynamicSqlSupport.isOpen).toProperty("isOpen")
            .map(FriendLinkDynamicSqlSupport.createUserId).toProperty("createUserId")
            .map(FriendLinkDynamicSqlSupport.createTime).toProperty("createTime")
            .map(FriendLinkDynamicSqlSupport.updateUserId).toProperty("updateUserId")
            .map(FriendLinkDynamicSqlSupport.updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(FriendLink record) {
        return MyBatis3Utils.insert(this::insert, record, FriendLinkDynamicSqlSupport.friendLink, c ->
            c.map(FriendLinkDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(FriendLinkDynamicSqlSupport.linkName).toPropertyWhenPresent("linkName", record::getLinkName)
            .map(FriendLinkDynamicSqlSupport.linkUrl).toPropertyWhenPresent("linkUrl", record::getLinkUrl)
            .map(FriendLinkDynamicSqlSupport.sort).toPropertyWhenPresent("sort", record::getSort)
            .map(FriendLinkDynamicSqlSupport.isOpen).toPropertyWhenPresent("isOpen", record::getIsOpen)
            .map(FriendLinkDynamicSqlSupport.createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
            .map(FriendLinkDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(FriendLinkDynamicSqlSupport.updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
            .map(FriendLinkDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FriendLink> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FriendLink> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FriendLink> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FriendLink> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(FriendLinkDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, FriendLinkDynamicSqlSupport.friendLink, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(FriendLink record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FriendLinkDynamicSqlSupport.id).equalTo(record::getId)
                .set(FriendLinkDynamicSqlSupport.linkName).equalTo(record::getLinkName)
                .set(FriendLinkDynamicSqlSupport.linkUrl).equalTo(record::getLinkUrl)
                .set(FriendLinkDynamicSqlSupport.sort).equalTo(record::getSort)
                .set(FriendLinkDynamicSqlSupport.isOpen).equalTo(record::getIsOpen)
                .set(FriendLinkDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
                .set(FriendLinkDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(FriendLinkDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
                .set(FriendLinkDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FriendLink record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(FriendLinkDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(FriendLinkDynamicSqlSupport.linkName).equalToWhenPresent(record::getLinkName)
                .set(FriendLinkDynamicSqlSupport.linkUrl).equalToWhenPresent(record::getLinkUrl)
                .set(FriendLinkDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
                .set(FriendLinkDynamicSqlSupport.isOpen).equalToWhenPresent(record::getIsOpen)
                .set(FriendLinkDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(FriendLinkDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(FriendLinkDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(FriendLinkDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(FriendLink record) {
        return update(c ->
            c.set(FriendLinkDynamicSqlSupport.linkName).equalTo(record::getLinkName)
            .set(FriendLinkDynamicSqlSupport.linkUrl).equalTo(record::getLinkUrl)
            .set(FriendLinkDynamicSqlSupport.sort).equalTo(record::getSort)
            .set(FriendLinkDynamicSqlSupport.isOpen).equalTo(record::getIsOpen)
            .set(FriendLinkDynamicSqlSupport.createUserId).equalTo(record::getCreateUserId)
            .set(FriendLinkDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(FriendLinkDynamicSqlSupport.updateUserId).equalTo(record::getUpdateUserId)
            .set(FriendLinkDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .where(FriendLinkDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(FriendLink record) {
        return update(c ->
            c.set(FriendLinkDynamicSqlSupport.linkName).equalToWhenPresent(record::getLinkName)
            .set(FriendLinkDynamicSqlSupport.linkUrl).equalToWhenPresent(record::getLinkUrl)
            .set(FriendLinkDynamicSqlSupport.sort).equalToWhenPresent(record::getSort)
            .set(FriendLinkDynamicSqlSupport.isOpen).equalToWhenPresent(record::getIsOpen)
            .set(FriendLinkDynamicSqlSupport.createUserId).equalToWhenPresent(record::getCreateUserId)
            .set(FriendLinkDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(FriendLinkDynamicSqlSupport.updateUserId).equalToWhenPresent(record::getUpdateUserId)
            .set(FriendLinkDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(FriendLinkDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}