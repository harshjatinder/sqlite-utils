package `in`.dev.sqlite_utils

/**
 * Created by harsh on 28/1/18.
 * Generates SQLite query to Create Table
 */
object SqliteUtils {

    class CreateTable(private val tableName: String) {

        private var query = String()
        private var hasColumns = false

        init {
            query = "CREATE TABLE ".plus(tableName).openParens()
        }

        /**
         * @param name: Name of the column
         * @param type: Data type of the column
         * @param primaryKey: If true column will be set as primary key
         * @param autoIncrement: If true column value will autoIncrement (For Integer Type only)
         * @param notNull: If true column will be set as Not Null
         */
        fun addColumn(
                name: String,
                type: DATA_TYPE,
                primaryKey: Boolean = false,
                autoIncrement: Boolean = false,
                notNull: Boolean = false
        ): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.plus(name).space().plus(type)
            if (primaryKey) query = query.space().plus("PRIMARY KEY")
            else if (notNull) query = query.space().plus("NOT NULL")
            if (autoIncrement && type.equals(DATA_TYPE.INTEGER)) query = query.space().plus("AUTOINCREMENT")
            hasColumns = true
            return this
        }

        /**
         * @param name: Name of the column
         * @param type: Data type of the column
         * @param table: Reference CreateTable name of foreign key
         */
        fun addForeignKeyColumn(
                name: String,
                type: DATA_TYPE,
                table: String): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.space().plus(name).space().plus(type).comma()
            query = query.space().plus("FOREIGN KEY").space().openParens().plus(name).closeParens()
            query = query.space().plus("REFERENCES").space().plus(table).space().openParens().plus(name).closeParens()
            hasColumns = true
            return this
        }

        fun getQuery(): String? {
            if (tableName.isEmpty()) return null
            else return query.closeParens().semicolon()
        }
    }
}