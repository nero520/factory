package com.msds.km.job;
//
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.msds.km.entity.OrderEntity;
//import com.msds.km.enums.OrderStateEnum;
//import com.msds.km.service.OrderService;
//import com.msds.util.DateUtils;
//
///**
// * 订单相关定时任务
// * 
// * @ClassName OrderJob
// * @Description TODO
// * @author LiLong
// * @date 2015年5月7日 下午1:53:59
// * 
// */
public class OrderJob {
//	private final static Logger log = LoggerFactory.getLogger(OrderJob.class);
//
//	@Autowired
//	OrderService orderService;
//
//	/**
//	 * 自动确认订单（待服务30天）
//	 */
//	public void autoConfirmReceipt() throws Exception {
//		log.info("============= 自动确认收货autoConfirmReceipt 开始  =======  ");
//		Date date = new Date();
//		List<OrderEntity> orderList = orderService.findListByStateLtDate(
//				OrderStateEnum.ORDER_WAIT_PAY, DateUtils.addDay(date, -30));
//		if (orderList != null && orderList.size() > 0) {
//			for (OrderEntity oe : orderList) {
//				orderService.updateOrderState(oe.getOrderSn(),
//						OrderStateEnum.ORDER_OVER, "定时任务完成订单");
//				log.info("============= 自动确认完成的订单编号：{} =======  ",
//						oe.getOrderSn());
//			}
//		}
//		log.info("============= 自动确认完成autoConfirmReceipt 结束  =======  ");
//	}
//
//	/**
//	 * 自动取消2小时未支付)
//	 */
//	public void autoCancelOrder() throws Exception {
//		log.info("============= 自动取消订单autoCancelOrder 开始  =======  ");
//		Date date = new Date();
//		List<OrderEntity> orderList = orderService.findListByStateLtDate(
//				OrderStateEnum.ORDER_WAIT_PAY, DateUtils.addHour(date, -2));
//		if (orderList != null && orderList.size() > 0) {
//			for (OrderEntity oe : orderList) {
//				orderService.updateOrderState(oe.getOrderSn(),
//						OrderStateEnum.ORDER_CANCEL, "定时任务取消订单");
//				log.info("=============  自动取消订单的订单编号： {}=======  ",
//						oe.getOrderSn());
//			}
//		}
//		log.info("============= 自动取消订单autoCancelOrder 结束  =======  ");
//	}
//
}
