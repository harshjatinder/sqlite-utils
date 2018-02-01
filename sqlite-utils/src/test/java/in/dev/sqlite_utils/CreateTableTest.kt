package `in`.dev.sqlite_utils

import `in`.dev.sqlite_utils.DATA_TYPE.*
import junit.framework.Assert
import org.junit.Test

/**
 * Created by harsh on 28/1/18.
 * Test of SqliteUtils.CreateTable
 */
class CreateTableTest {

    private val TABLE_USERS = "users"
    private val TABLE_PERSONS = "persons"
    private val COLUMN_ID = "id"
    private val COLUMN_NAME = "name"
    private val COLUMN_IMAGE = "image"
    private val COLUMN_FOREIGN_KEY = "user_id"
    private val EMPTY_STRING = String()

    @Test
    fun shouldReturnQueryToCreateTableWithNoColumn() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(TABLE_PERSONS)
                .getQuery()
        //Then
        Assert.assertEquals(true, (query != null))
        println(query)
    }

    @Test
    fun shouldNotReturnQueryToCreateTableWithNoColumn() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(EMPTY_STRING)
                .getQuery()
        //Then
        Assert.assertEquals(true, (query == null))
        println(query)
    }

    @Test
    fun shouldReturnQueryToCreateTableWithSingleColumn() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(TABLE_PERSONS)
                .addColumn(COLUMN_ID, INTEGER)
                .getQuery()
        //Then
        Assert.assertEquals(true, (query != null))
        println(query)
    }

    @Test
    fun shouldNotReturnQueryToCreateTableWithSingleColumn() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(EMPTY_STRING)
                .addColumn(COLUMN_ID, INTEGER)
                .getQuery()
        //Then
        Assert.assertEquals(true, (query == null))
        println(query)
    }

    @Test
    fun shouldReturnQueryToCreateTableWithMultipleColumns() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(TABLE_PERSONS)
                .also {
                    it.addColumn(COLUMN_ID, INTEGER, true, autoIncrement = true)
                    it.addColumn(COLUMN_NAME, TEXT, notNull = true)
                    it.addColumn(COLUMN_IMAGE, BLOB)
                    it.addForeignKeyColumn(COLUMN_FOREIGN_KEY, INTEGER, TABLE_USERS, COLUMN_ID)
                }.getQuery()
        //Then
        Assert.assertEquals(true, (query != null))
        println(query)
    }

    @Test
    fun shouldNotReturnQueryToCreateTableWithMultipleColumns() {
        //Given
        val query: String?
        //When
        query = SqliteUtils.CreateTable(EMPTY_STRING)
                .also {
                    it.addColumn(COLUMN_ID, INTEGER, true, autoIncrement = true)
                    it.addColumn(COLUMN_NAME, TEXT, notNull = true)
                    it.addColumn(COLUMN_IMAGE, BLOB)
                    it.addForeignKeyColumn(COLUMN_FOREIGN_KEY, INTEGER, TABLE_USERS, COLUMN_ID)
                }.getQuery()
        //Then
        Assert.assertEquals(true, (query == null))
        println(query)
    }

}