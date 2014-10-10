/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Daniel Gimenes
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the ("Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED ("AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package br.com.dgimenes.sqlstringgenerator;

public class SqlStringGenerator {

	private String tableName;

	public SqlStringGenerator(String tableName) {
		this.tableName = tableName;
	}

	public String getSelect(String[] columns) {
		StringBuilder res = new StringBuilder();
		res.append("select ");
		res.append(getComaSeparatedStrings(columns));
		res.append(" from ");
		res.append(tableName);
		return res.toString();
	}

	private String getComaSeparatedStrings(String[] strings) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < strings.length - 1; i++) {
			res.append(strings[i]);
			res.append(",");
		}
		res.append(strings[strings.length - 1]);
		return res.toString();
	}

	public String getInsert(String[] columns, Object[] values) {
		StringBuilder res = new StringBuilder();
		res.append("insert into ");
		res.append(tableName);
		res.append("(");
		res.append(getComaSeparatedStrings(columns));
		res.append(") values (");
		res.append(getComaSeparatedObjectSqlStr(values));
		res.append(")");
		return res.toString();
	}

	private String getComaSeparatedObjectSqlStr(Object[] values) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < values.length - 1; i++) {
			res.append(getObjectSqlStr(values[i]));
			res.append(",");
		}
		res.append(getObjectSqlStr(values[values.length - 1]));
		return res.toString();
	}

	private String getObjectSqlStr(Object object) {
		StringBuilder res = new StringBuilder();
		if (object instanceof String) {
			res.append("'");
			res.append(object);
			res.append("'");
		} else if (object instanceof Double) {
			res.append(object);
		} else {
			res.append(object);
		}
		return res.toString();
	}

	public String getUpdate(String[] columns, Object[] values) {
		StringBuilder res = new StringBuilder();
		res.append("update ");
		res.append(tableName);
		res.append(" set ");
		res.append(getComaSeparatedSetValueString(columns, values));
		return res.toString();
	}

	private String getComaSeparatedSetValueString(String[] columns, Object[] values) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < values.length - 1; i++) {
			res.append(columns[i]);
			res.append(" = ");
			res.append(getObjectSqlStr(values[i]));
			res.append(", ");
		}
		res.append(columns[values.length - 1]);
		res.append(" = ");
		res.append(getObjectSqlStr(values[values.length - 1]));
		return res.toString();
	}

	public String getDelete() {
		StringBuilder res = new StringBuilder();
		res.append("delete from ");
		res.append(tableName);
		return res.toString();
	}

}
