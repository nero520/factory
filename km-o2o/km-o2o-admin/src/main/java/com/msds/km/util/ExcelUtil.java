/**
 * 
 */
package com.msds.km.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;

/**
 * Excel导出处理类
 * 
 * @author zhengxd
 * @version 2011-7-20
 */
public class ExcelUtil {

	public static void expToExcel(List<?> objList, BaseObject obj,
			String classZ, OutputStream outs) {

		List<String[]> valueList = new ArrayList<String[]>();

		String[] headers = obj.getHeaders();
		String[] dataIndexs = obj.getDataIndexs();

		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;
		try {
			classType = Class.forName(classZ);
			for (int i = 0; i < objList.size(); i++) {
				Object o = objList.get(i);

				String[] values = new String[headers.length];

				for (int j = 0; j < dataIndexs.length; j++) {
					String stringLetter = dataIndexs[j].substring(0, 1)
							.toUpperCase();
					String getName = "get" + stringLetter
							+ dataIndexs[j].substring(1);
					Method getMethod;
					try {
						getMethod = classType.getMethod(getName);
						Object value;
						try {
							value = getMethod.invoke(o);
							if (getMethod.getReturnType() == Date.class) {
								if (null != value && !"".equals(value))
									values[j] = DateUtils.DateToString(
											(Date) value, DateStyle.YYYY_MM_DD);
								else
									values[j] = "";
							} else {
								values[j] = null != value ? value.toString()
										: "-";
							}
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}

				valueList.add(values);
			}

			fillExcel(wb, headers, valueList, outs);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 分多个sheet导出
	public static void expToExcelFormat(List<?> objList, BaseObject obj,
			String classZ, OutputStream outs, int count) {

		List<String[]> valueList = new ArrayList<String[]>();

		String[] headers = obj.getHeaders();
		String[] dataIndexs = obj.getDataIndexs();

		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;
		try {
			classType = Class.forName(classZ);
			for (int i = 0; i < objList.size(); i++) {
				Object o = objList.get(i);

				String[] values = new String[headers.length];

				for (int j = 0; j < dataIndexs.length; j++) {
					String stringLetter = dataIndexs[j].substring(0, 1)
							.toUpperCase();
					String getName = "get" + stringLetter
							+ dataIndexs[j].substring(1);
					Method getMethod;
					try {
						getMethod = classType.getMethod(getName);
						Object value;
						try {
							value = getMethod.invoke(o);
							if (getMethod.getReturnType() == Date.class) {
								if (null != value && !"".equals(value))
									values[j] = DateUtils.DateToString(
											(Date) value, DateStyle.YYYY_MM_DD);
								else
									values[j] = "";
							} else {
								values[j] = null != value ? value.toString()
										: "-";
							}
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}

				valueList.add(values);
			}

			// added by zhengxd 2012-08-04 大数据量导出时，拆分成多个sheet
			// int count = 50000;//每个sheet的条数
			int sheetCount = valueList.size() / count + 1;

			for (int i = 0; i < sheetCount; i++) {

				int start = i * count;
				int end = (i + 1) * count;
				List<String[]> spList = new ArrayList<String[]>();
				if (end > valueList.size()) {
					spList = valueList.subList(start, valueList.size());
				} else {
					spList = valueList.subList(start, end);
				}
				fillExcelFormat(wb, headers, spList, outs);

			}

			try {
				wb.write(outs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 分多个sheet导出
	@SuppressWarnings("rawtypes")
	public static void expToExcel(Map<Map, List> map, OutputStream outs) {

		// map中封装了一个basemap、一个list
		// basemap又封装了一个字符串和一个对象（"发货汇总@com.yougou.order.domain.OrderSaleKPI",
		// baseObject）
		// list就是将要导出的数据列表， basemap中包括sheet名称 映射用的class 以及baseObject对象
		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;

		try {
			Set<Map.Entry<Map, List>> set = map.entrySet();
			for (Iterator<Map.Entry<Map, List>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<Map, List> entry = (Map.Entry<Map, List>) it.next();

				List<String[]> valueList = new ArrayList<String[]>();

				Map<String, BaseObject> baseMap = entry.getKey();

				Set<Map.Entry<String, BaseObject>> baseSet = baseMap.entrySet();
				for (Iterator<Map.Entry<String, BaseObject>> its = baseSet
						.iterator(); its.hasNext();) {
					Map.Entry<String, BaseObject> entrys = (Map.Entry<String, BaseObject>) its
							.next();

					BaseObject obj = entrys.getValue();
					String[] headers = obj.getHeaders();
					String[] dataIndexs = obj.getDataIndexs();

					// 将sheet名称与对应的PO对象用“@”拆分
					String arr[] = entrys.getKey().toString().split("@");
					classType = Class.forName(arr[1]);

					for (int i = 0; i < entry.getValue().size(); i++) {
						Object o = entry.getValue().get(i);
						String[] values = new String[headers.length];
						for (int j = 0; j < dataIndexs.length; j++) {
							String stringLetter = dataIndexs[j].substring(0, 1)
									.toUpperCase();
							String getName = "get" + stringLetter
									+ dataIndexs[j].substring(1);
							Method getMethod;
							try {
								getMethod = classType.getMethod(getName);
								Object value;
								try {
									value = getMethod.invoke(o);
									if (getMethod.getReturnType() == Date.class) {
										if (null != value && !"".equals(value))
											values[j] = DateUtils.DateToString(
													(Date) value,
													DateStyle.YYYY_MM_DD);
										else
											values[j] = "";
									} else {
										values[j] = null != value ? value
												.toString() : "-";
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							}
						}
						valueList.add(values);
					}
					// 指定sheet名称
					fillExcelFormat(wb, arr[0], headers, valueList, outs);
				}
			}
			try {
				wb.write(outs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 分多个sheet导出
	@SuppressWarnings("rawtypes")
	public static void expToExcel(Map<Map, List> map, String filePath) {

		// map中封装了一个basemap、一个list
		// basemap又封装了一个字符串和一个对象（"发货汇总@com.yougou.order.domain.OrderSaleKPI",
		// baseObject）
		// list就是将要导出的数据列表， basemap中包括sheet名称 映射用的class 以及baseObject对象
		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;

		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			Set<Map.Entry<Map, List>> set = map.entrySet();
			for (Iterator<Map.Entry<Map, List>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<Map, List> entry = (Map.Entry<Map, List>) it.next();

				List<String[]> valueList = new ArrayList<String[]>();

				Map<String, BaseObject> baseMap = entry.getKey();

				Set<Map.Entry<String, BaseObject>> baseSet = baseMap.entrySet();
				for (Iterator<Map.Entry<String, BaseObject>> its = baseSet
						.iterator(); its.hasNext();) {
					Map.Entry<String, BaseObject> entrys = (Map.Entry<String, BaseObject>) its
							.next();

					BaseObject obj = entrys.getValue();
					String[] headers = obj.getHeaders();
					String[] dataIndexs = obj.getDataIndexs();

					// 将sheet名称与对应的PO对象用“@”拆分
					String arr[] = entrys.getKey().toString().split("@");
					classType = Class.forName(arr[1]);

					for (int i = 0; i < entry.getValue().size(); i++) {
						Object o = entry.getValue().get(i);
						String[] values = new String[headers.length];
						for (int j = 0; j < dataIndexs.length; j++) {
							String stringLetter = dataIndexs[j].substring(0, 1)
									.toUpperCase();
							String getName = "get" + stringLetter
									+ dataIndexs[j].substring(1);
							Method getMethod;
							try {
								getMethod = classType.getMethod(getName);
								Object value;
								try {
									value = getMethod.invoke(o);
									if (getMethod.getReturnType() == Date.class) {
										if (null != value && !"".equals(value))
											values[j] = DateUtils.DateToString(
													(Date) value,
													DateStyle.YYYY_MM_DD);
										else
											values[j] = "";
									} else {
										values[j] = null != value ? value
												.toString() : "-";
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							}
						}
						valueList.add(values);
					}
					// 指定sheet名称
					fillExcelFormat(wb, arr[0], headers, valueList, fileOut);
				}
			}
			try {

				wb.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void fillExcel(HSSFWorkbook wb, String[] headers,
			List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// HSSFFont fontC = wb.createFont();
			// 高度
			// fontC.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			// HSSFCellStyle styleC = wb.createCellStyle();
			// styleC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// styleC.setFont(fontC);
			// styleC.setFillForegroundColor(HSSFColor.WHITE.index);
			// styleC.setBorderLeft((short) 1);
			// styleC.setBorderRight((short) 1);
			// styleC.setBorderTop((short) 1);
			// styleC.setWrapText(true);
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);

				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					// cell.setCellStyle(styleC);
					cell.setCellValue(new HSSFRichTextString(values[j]));
				}
			}
			wb.write(outs);
			// FileOutputStream fileOs;
			// fileOs = new FileOutputStream(new File("E:\\USR_TEST.xls"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fillExcelFormat(HSSFWorkbook wb, String[] headers,
			List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// 数字转换
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellStyle(cellstyle);
							cell.setCellValue(Float.parseFloat(values[j]));

						} else if (mX.matches()) {
							cell.setCellStyle(cellstyleX);
							cell.setCellValue(Float.parseFloat(values[j]));

						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fillExcelFormat(HSSFWorkbook wb, String sheetName,
			String[] headers, List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet(sheetName);
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// 数字转换
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellStyle(cellstyle);
							cell.setCellValue(Long.parseLong(values[j]));
						} else if (mX.matches()) {
							cell.setCellStyle(cellstyleX);
							cell.setCellValue(Float.parseFloat(values[j]));
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Excel导出，从界面获取导出的数据
	 */
	public static void expToExcel(BaseObject obj, OutputStream outs) {
		String[] headers = obj.getHeaders();
		String[] rowsDatas = obj.getRowDatas();
		HSSFWorkbook wb = new HSSFWorkbook();

		try {

			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);
			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}
			// 数字转换
			for (int i = 0; i < rowsDatas.length; i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = rowsDatas[i].split("@");
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyle);
						} else if (mX.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyleX);
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]
									.trim()));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

			wb.write(outs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void expToExcelSymbo(BaseObject obj, OutputStream outs,
			String symbo) {
		String[] headers = obj.getHeaders();
		String[] rowsDatas = obj.getRowDatas();
		HSSFWorkbook wb = new HSSFWorkbook();

		try {

			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);
			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}
			// 数字转换
			for (int i = 0; i < rowsDatas.length; i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = rowsDatas[i].split(symbo);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyle);
						} else if (mX.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyleX);
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

			wb.write(outs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private POIFSFileSystem fs;
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    /**
     * 读取Excel表格表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle(InputStream is) {
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     */
    public Map<Integer, String> readExcelContent(InputStream is) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            
           
            try {
            	wb = new XSSFWorkbook(is);
            } catch (Exception ex) {
            	wb = new HSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + "@@@";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     * 
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            strCell = String.valueOf(cell.getNumericCellValue());
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }

    /**
     * 获取单元格数据内容为日期类型的数据
     * 
     * @param cell
     *            Excel单元格
     * @return String 单元格数据内容
     */
    private String getDateCellValue(HSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("日期格式不正确!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case Cell.CELL_TYPE_NUMERIC:
            case Cell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static void main(String[] args) {
    	
//    	
//    	String fileName = "/Users/zhengxd/Documents/工具/apache-tomcat-8.0.23/webapps/upload/files/model/20151027/5d3478236c0043d2afe9e388753b7b27.xlsx";
//        try {
//        	 ExcelUtil excelReader = new ExcelUtil();
//            // 对读取Excel表格标题测试
////            InputStream is = new FileInputStream(fileName);
////            String[] title = excelReader.readExcelTitle(is);
////            System.out.println("获得Excel表格的标题:");
////            for (String s : title) {
////                System.out.print(s + " ");
////            }
//
//            // 对读取Excel表格内容测试
//            InputStream is2 = new FileInputStream(fileName);
//            Map<Integer, String> map = excelReader.readExcelContent(is2);
//            System.out.println("获得Excel表格的内容:");
//            for (int i = 1; i <= map.size(); i++) {
//                System.out.println(map.get(i));
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("未找到指定路径的文件!");
//            e.printStackTrace();
//        }
    	
    	
    	int count = 1099 / 100;
    	int count1 = 1099 % 100;
    	System.out.println(count+"-"+count1);
    	
    }


}
