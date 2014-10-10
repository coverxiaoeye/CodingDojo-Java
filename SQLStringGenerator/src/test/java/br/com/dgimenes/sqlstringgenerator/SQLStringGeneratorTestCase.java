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

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLStringGeneratorTestCase {
	
	// SELECT
	
	@Test
	public void testSimpleSELECT_1() {
		String tableName = "x";
		String[] columns = {"a", "b", "c"};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String selectSQL = generator.getSelect(columns);
		assertEquals("select a,b,c from x", selectSQL);
	}
	
	@Test
	public void testSimpleSELECT_2() {
		String tableName = "customer";
		String[] columns = {"id", "name", "address"};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String selectSQL = generator.getSelect(columns);
		assertEquals("select id,name,address from customer", selectSQL);
	}
	
	// INSERT
	
	@Test
	public void testSimpleINSERT_1() {
		String tableName = "x";
		String[] columns = {"a", "b", "c"};
		Object[] values = {false, "Daniel", 1.0D};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String insertSQL = generator.getInsert(columns, values);
		assertEquals("insert into x(a,b,c) values (false,'Daniel',1.0)", insertSQL);
	}
	
	@Test
	public void testSimpleINSERT_2() {
		String tableName = "customer";
		String[] columns = {"id", "name", "address"};
		Object[] values = {1, "Daniel", "22, Some St."};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String insertSQL = generator.getInsert(columns, values);
		assertEquals("insert into customer(id,name,address) values (1,'Daniel','22, Some St.')", insertSQL);
	}
	
	// UPDATE
	
	@Test
	public void testSimpleUPDATE_1() {
		String tableName = "x";
		String[] columns = {"a", "b", "c"};
		Object[] values = {false, "Daniel", 1.0D};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String updateSQL = generator.getUpdate(columns, values);
		assertEquals("update x set a = false, b = 'Daniel', c = 1.0", updateSQL);
	}
	
	@Test
	public void testSimpleUPDATE_2() {
		String tableName = "customer";
		String[] columns = {"id", "name", "address"};
		Object[] values = {1, "Daniel", "22, Some St."};
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String updateSQL = generator.getUpdate(columns, values);
		assertEquals("update customer set id = 1, name = 'Daniel', address = '22, Some St.'", updateSQL);
	}
	
	// DELETE
	
	@Test
	public void testSimpleDELETE_1() {
		String tableName = "x";
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String deleteSQL = generator.getDelete();
		assertEquals("delete from x", deleteSQL);
	}
	
	@Test
	public void testSimpleDELETE_2() {
		String tableName = "customer";
		SqlStringGenerator generator = new SqlStringGenerator(tableName);
		String deleteSQL = generator.getDelete();
		assertEquals("delete from customer", deleteSQL);
	}
}
