from pymysql import cursors , connect

class MySQLConnection:

    def __init__(self, dbName):
        self.connection = connect(
            host = "localhost",
            user = "root",
            password = "Que/2002",
            database = dbName,
            charset = "utf8mb4",
            cursorclass = cursors.DictCursor,
            autocommit = True
        )

    def query_db(self, query, data = None):
        with self.connection.cursor() as cursor:
            try :
                # EXECUTING THE QUERY
                query = cursor.mogrify(query, data)
                print("Running Query:", query)
                cursor.execute(query, data)

                # RESULT FILTERING
                if query.lower().find("insert") >= 0:
                    return cursor.lastrowid
                elif query.lower().find("select") >= 0:
                    result = cursor.fetchall()
                    return result
            except Exception as e:
                print("Something went wrong", e)
                return False
            finally:
                self.connection.close()

def connectToMySQL(dbName):
    return MySQLConnection(dbName)