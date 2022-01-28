from pymysql import cursors, connect

class MySQLConnection:

    def __init__(self):
        self.connection = connect(
            user = "root",
            host = "localhost",
            password = "Que/2002",
            database = "dojos_ninjas",
            charset = "utf8mb4",
            cursorclass = cursors.DictCursor,
            autocommit = True,
        )

    def query_db(self, query, data = None):
        with self.connection.cursor() as cursor:
            try:
                query = cursor.mogrify(query, data)
                print ("--------- EXECUTING - ", query)
                cursor.execute(query)
                if query.lower().find("insert") >= 0:
                    return cursor.lastrowid
                elif query.lower().find("select") >= 0:
                    result = cursor.fetchall()
                    return result
            except Exception as e:
                print ("--------- ERROR - ", e)
            finally:
                self.connection.close()

def connectToMySQL():
    return MySQLConnection()