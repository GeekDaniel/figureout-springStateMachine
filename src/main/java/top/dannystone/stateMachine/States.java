package top.dannystone.stateMachine;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * Creed: keep it simple and stupid !
 * Time: 2020/8/6 6:07 PM
 */
public enum States {
    INIT //初始化
    , WAIT_PAYMENT //待支付
    , PAY_SUCCESS //支付成功
    , PAY_CROSS_BORDER_ING //报关中
    , PAY_CROSS_BORDER_SUCCESS //待平台收货
    , PAY_CROSS_BORDER_FAIL //支付报关失败
    , WAIT_PLATFORM_RECEIVED //待平台发货
    , PLATFORM_RECEIVED //平台已收货
    , QUALITY_CHECK_SUCCESS //质检成功
    , WAIT_PLATFORM_SEND //待平台发货
    , WAIT_BUYER_RECEIVED //待买家收货
    , TRADE_SUCCESS //交易成功
    , TRADE_CLOSED //交易关闭

}
