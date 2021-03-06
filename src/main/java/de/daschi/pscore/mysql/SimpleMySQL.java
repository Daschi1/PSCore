package de.daschi.pscore.mysql;

import de.daschi.core.MySQL;
import javax.sql.rowset.CachedRowSet;
import org.jetbrains.annotations.NotNull;

public class SimpleMySQL {

  public static CachedRowSet select(@NotNull final String table,
                                    @NotNull final String whereColumn,
                                    @NotNull final String whereComparator,
                                    @NotNull final Object whereValue) {
    return MySQL.query("SELECT * FROM `" + MySQL.preventSQLInjection(table) +
                       "' WHERE `" + MySQL.preventSQLInjection(whereColumn) +
                       "` " + MySQL.preventSQLInjection(whereComparator) +
                       " '" + MySQL.preventSQLInjection(whereValue.toString()) +
                       "';");
  }

  public static void insert(@NotNull final String table,
                            @NotNull final Object... values) {
    final StringBuilder stringBuilder = new StringBuilder("(");
    for (final Object value : values) {
      stringBuilder.append(MySQL.preventSQLInjection(value.toString()))
          .append(", ");
    }
    MySQL.update("INSERT INTO `" + MySQL.preventSQLInjection(table) +
                 "` VALUES " +
                 stringBuilder.substring(0, stringBuilder.length() - 3) + ");");
  }

  public static void update(@NotNull final String table,
                            @NotNull final String column,
                            @NotNull final Object value,
                            @NotNull final String whereColumn,
                            @NotNull final String whereComparator,
                            @NotNull final Object whereValue) {
    MySQL.update("UPDATE `" + MySQL.preventSQLInjection(table) + "` SET `" +
                 MySQL.preventSQLInjection(column) + "` = '" +
                 MySQL.preventSQLInjection(value.toString()) + "' WHERE `" +
                 MySQL.preventSQLInjection(whereColumn) + "` " +
                 MySQL.preventSQLInjection(whereComparator) + " '" +
                 MySQL.preventSQLInjection(whereValue.toString()) + "';");
  }

  public static void delete(@NotNull final String table,
                            @NotNull final String whereColumn,
                            @NotNull final String whereComparator,
                            @NotNull final Object whereValue) {
    MySQL.update("DELETE FROM `" + MySQL.preventSQLInjection(table) +
                 "' WHERE `" + MySQL.preventSQLInjection(whereColumn) + "` " +
                 MySQL.preventSQLInjection(whereComparator) + " '" +
                 MySQL.preventSQLInjection(whereValue.toString()) + "';");
  }
}
