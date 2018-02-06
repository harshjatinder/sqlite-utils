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
            query = "CREATE TABLE IF NOT EXISTS ".plus(tableName).openParens()
        }

        /**
         * Adds created_at column automatically with (DATETIME DEFAULT CURRENT_TIMESTAMP)
         */
        fun addCreatedAt(): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.plus(CREATED_AT).space().plus(DATETIME_DEFAULT_TIMESTAMP)
            hasColumns = true
            return this
        }

        /**
         * Adds updated_at column automatically with (DATETIME DEFAULT CURRENT_TIMESTAMP)
         */
        fun addUpdatedAt(): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.plus(UPDATED_AT).space().plus(DATETIME_DEFAULT_TIMESTAMP)
            hasColumns = true
            return this
        }

        /**
         * Adds removed_at column automatically with (DATETIME DEFAULT CURRENT_TIMESTAMP)
         */
        fun addRemovedAt(): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.plus(REMOVED_AT).space().plus(DATETIME)
            hasColumns = true
            return this
        }

        /**
         * @param name: Name of the column
         * @param type: Data type of the column
         * @param primaryKey: If true column will be set as primary key
         * @param autoIncrement: If true column value will autoIncrement (For Integer Type only)
         * @param notNull: If true column will be set as Not Null
         * @param defaultValue: default value for column (NOT ALLOWED FOR DATATYPE = BLOB || NULL)
         */
        fun addColumn(
                name: String,
                type: DATA_TYPE,
                primaryKey: Boolean = false,
                autoIncrement: Boolean = false,
                notNull: Boolean = false,
                defaultValue: String? = null
        ): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.plus(name).space().plus(type)
            if (primaryKey) query = query.space().plus("PRIMARY KEY")
            else if (notNull) query = query.space().plus("NOT NULL")
            if (autoIncrement && type.equals(DATA_TYPE.INTEGER)) query = query.space().plus("AUTOINCREMENT")
            if (!defaultValue.isNullOrEmpty()) {
                when (type) {
                    DATA_TYPE.TEXT -> query = query.space().plus(DEFAULT).space()
                            .singleQuote().plus(defaultValue).singleQuote()
                    DATA_TYPE.INTEGER -> query = query.space().plus(DEFAULT).space().plus(defaultValue)
                    DATA_TYPE.REAL -> query = query.space().plus(DEFAULT).space().plus(defaultValue)
                    else -> {
                        //DO-NOTHING
                    }
                }
            }
            hasColumns = true
            return this
        }

        /**
         * @param name: Name of the column
         * @param type: Data type of the column
         * @param refTable: Reference Table name of foreign key
         * @param refColumn: Reference column name of foreign key
         */
        fun addForeignKeyColumn(
                name: String,
                type: DATA_TYPE,
                refTable: String,
                refColumn: String,
                onDeleteCascade: Boolean,
                onUpdateCascade: Boolean): CreateTable {
            if (hasColumns) query = query.comma()
            query = query.space().plus(name).space().plus(type).comma()
            query = query.space().plus("FOREIGN KEY").space().openParens().plus(name).closeParens()
            query = query.space().plus("REFERENCES").space().plus(refTable).space().openParens().plus(refColumn).closeParens()
            if (onDeleteCascade) query = query.space().plus("ON DELETE CASCADE")
            if (onUpdateCascade) query = query.space().plus("ON UPDATE CASCADE")
            hasColumns = true
            return this
        }

        /**
         * @return: generated query as String
         */
        fun getQuery(): String? {
            if (tableName.isEmpty()) return null
            else return query.closeParens().semicolon()
        }

        companion object {
            const val CURRENT_TIMESTAMP = "CURRENT_TIMESTAMP"
            const val CREATED_AT = "created_at"
            const val UPDATED_AT = "updated_at"
            const val REMOVED_AT = "removed_at"
            private const val DATETIME = "DATETIME"
            private const val DEFAULT = "DEFAULT"
            private val DATETIME_DEFAULT_TIMESTAMP = DATETIME.space().plus(DEFAULT).space().plus(CURRENT_TIMESTAMP)
        }
    }
}