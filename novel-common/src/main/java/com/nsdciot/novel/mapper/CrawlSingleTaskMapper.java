package com.nsdciot.novel.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.nsdciot.novel.entity.CrawlSingleTask;
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
public interface CrawlSingleTaskMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(CrawlSingleTaskDynamicSqlSupport.id, CrawlSingleTaskDynamicSqlSupport.sourceId, CrawlSingleTaskDynamicSqlSupport.sourceName, CrawlSingleTaskDynamicSqlSupport.sourceBookId, CrawlSingleTaskDynamicSqlSupport.catId, CrawlSingleTaskDynamicSqlSupport.bookName, CrawlSingleTaskDynamicSqlSupport.authorName, CrawlSingleTaskDynamicSqlSupport.taskStatus, CrawlSingleTaskDynamicSqlSupport.excCount, CrawlSingleTaskDynamicSqlSupport.createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CrawlSingleTask> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CrawlSingleTask> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CrawlSingleTaskResult")
    Optional<CrawlSingleTask> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CrawlSingleTaskResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="source_name", property="sourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_book_id", property="sourceBookId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_status", property="taskStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="exc_count", property="excCount", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CrawlSingleTask> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(CrawlSingleTaskDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(CrawlSingleTask record) {
        return MyBatis3Utils.insert(this::insert, record, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, c ->
            c.map(CrawlSingleTaskDynamicSqlSupport.id).toProperty("id")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceId).toProperty("sourceId")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceName).toProperty("sourceName")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceBookId).toProperty("sourceBookId")
            .map(CrawlSingleTaskDynamicSqlSupport.catId).toProperty("catId")
            .map(CrawlSingleTaskDynamicSqlSupport.bookName).toProperty("bookName")
            .map(CrawlSingleTaskDynamicSqlSupport.authorName).toProperty("authorName")
            .map(CrawlSingleTaskDynamicSqlSupport.taskStatus).toProperty("taskStatus")
            .map(CrawlSingleTaskDynamicSqlSupport.excCount).toProperty("excCount")
            .map(CrawlSingleTaskDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<CrawlSingleTask> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, c ->
            c.map(CrawlSingleTaskDynamicSqlSupport.id).toProperty("id")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceId).toProperty("sourceId")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceName).toProperty("sourceName")
            .map(CrawlSingleTaskDynamicSqlSupport.sourceBookId).toProperty("sourceBookId")
            .map(CrawlSingleTaskDynamicSqlSupport.catId).toProperty("catId")
            .map(CrawlSingleTaskDynamicSqlSupport.bookName).toProperty("bookName")
            .map(CrawlSingleTaskDynamicSqlSupport.authorName).toProperty("authorName")
            .map(CrawlSingleTaskDynamicSqlSupport.taskStatus).toProperty("taskStatus")
            .map(CrawlSingleTaskDynamicSqlSupport.excCount).toProperty("excCount")
            .map(CrawlSingleTaskDynamicSqlSupport.createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CrawlSingleTask record) {
        return MyBatis3Utils.insert(this::insert, record, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, c ->
            c.map(CrawlSingleTaskDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(CrawlSingleTaskDynamicSqlSupport.sourceId).toPropertyWhenPresent("sourceId", record::getSourceId)
            .map(CrawlSingleTaskDynamicSqlSupport.sourceName).toPropertyWhenPresent("sourceName", record::getSourceName)
            .map(CrawlSingleTaskDynamicSqlSupport.sourceBookId).toPropertyWhenPresent("sourceBookId", record::getSourceBookId)
            .map(CrawlSingleTaskDynamicSqlSupport.catId).toPropertyWhenPresent("catId", record::getCatId)
            .map(CrawlSingleTaskDynamicSqlSupport.bookName).toPropertyWhenPresent("bookName", record::getBookName)
            .map(CrawlSingleTaskDynamicSqlSupport.authorName).toPropertyWhenPresent("authorName", record::getAuthorName)
            .map(CrawlSingleTaskDynamicSqlSupport.taskStatus).toPropertyWhenPresent("taskStatus", record::getTaskStatus)
            .map(CrawlSingleTaskDynamicSqlSupport.excCount).toPropertyWhenPresent("excCount", record::getExcCount)
            .map(CrawlSingleTaskDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CrawlSingleTask> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CrawlSingleTask> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CrawlSingleTask> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CrawlSingleTask> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(CrawlSingleTaskDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, CrawlSingleTaskDynamicSqlSupport.crawlSingleTask, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CrawlSingleTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(CrawlSingleTaskDynamicSqlSupport.id).equalTo(record::getId)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceId).equalTo(record::getSourceId)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceName).equalTo(record::getSourceName)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceBookId).equalTo(record::getSourceBookId)
                .set(CrawlSingleTaskDynamicSqlSupport.catId).equalTo(record::getCatId)
                .set(CrawlSingleTaskDynamicSqlSupport.bookName).equalTo(record::getBookName)
                .set(CrawlSingleTaskDynamicSqlSupport.authorName).equalTo(record::getAuthorName)
                .set(CrawlSingleTaskDynamicSqlSupport.taskStatus).equalTo(record::getTaskStatus)
                .set(CrawlSingleTaskDynamicSqlSupport.excCount).equalTo(record::getExcCount)
                .set(CrawlSingleTaskDynamicSqlSupport.createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CrawlSingleTask record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(CrawlSingleTaskDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceId).equalToWhenPresent(record::getSourceId)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceName).equalToWhenPresent(record::getSourceName)
                .set(CrawlSingleTaskDynamicSqlSupport.sourceBookId).equalToWhenPresent(record::getSourceBookId)
                .set(CrawlSingleTaskDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
                .set(CrawlSingleTaskDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
                .set(CrawlSingleTaskDynamicSqlSupport.authorName).equalToWhenPresent(record::getAuthorName)
                .set(CrawlSingleTaskDynamicSqlSupport.taskStatus).equalToWhenPresent(record::getTaskStatus)
                .set(CrawlSingleTaskDynamicSqlSupport.excCount).equalToWhenPresent(record::getExcCount)
                .set(CrawlSingleTaskDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CrawlSingleTask record) {
        return update(c ->
            c.set(CrawlSingleTaskDynamicSqlSupport.sourceId).equalTo(record::getSourceId)
            .set(CrawlSingleTaskDynamicSqlSupport.sourceName).equalTo(record::getSourceName)
            .set(CrawlSingleTaskDynamicSqlSupport.sourceBookId).equalTo(record::getSourceBookId)
            .set(CrawlSingleTaskDynamicSqlSupport.catId).equalTo(record::getCatId)
            .set(CrawlSingleTaskDynamicSqlSupport.bookName).equalTo(record::getBookName)
            .set(CrawlSingleTaskDynamicSqlSupport.authorName).equalTo(record::getAuthorName)
            .set(CrawlSingleTaskDynamicSqlSupport.taskStatus).equalTo(record::getTaskStatus)
            .set(CrawlSingleTaskDynamicSqlSupport.excCount).equalTo(record::getExcCount)
            .set(CrawlSingleTaskDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .where(CrawlSingleTaskDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CrawlSingleTask record) {
        return update(c ->
            c.set(CrawlSingleTaskDynamicSqlSupport.sourceId).equalToWhenPresent(record::getSourceId)
            .set(CrawlSingleTaskDynamicSqlSupport.sourceName).equalToWhenPresent(record::getSourceName)
            .set(CrawlSingleTaskDynamicSqlSupport.sourceBookId).equalToWhenPresent(record::getSourceBookId)
            .set(CrawlSingleTaskDynamicSqlSupport.catId).equalToWhenPresent(record::getCatId)
            .set(CrawlSingleTaskDynamicSqlSupport.bookName).equalToWhenPresent(record::getBookName)
            .set(CrawlSingleTaskDynamicSqlSupport.authorName).equalToWhenPresent(record::getAuthorName)
            .set(CrawlSingleTaskDynamicSqlSupport.taskStatus).equalToWhenPresent(record::getTaskStatus)
            .set(CrawlSingleTaskDynamicSqlSupport.excCount).equalToWhenPresent(record::getExcCount)
            .set(CrawlSingleTaskDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .where(CrawlSingleTaskDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}