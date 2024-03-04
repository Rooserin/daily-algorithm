/**
 * @description:
 * @projectName:test
 * @see:PACKAGE_NAME
 * @author:王祎霖
 * @createTime:2024/2/22 14:57
 * @version:1.0
 */


public class Basket {
    /**
     * 篮子名称
     */
    private String name;
    /**
     * 转载货物
     */
    private Goods goods;

    public Basket() {
        System.out.println("创建了一个空蓝子");
    }

    public Basket(String name, Goods goods) {
        this.name = name;
        this.goods = goods;
        System.out.println("篮子" + name + "已创建，里面装了" + goods.getGoodsName());
    }

    public String getName() {
        return name;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void show() {
        System.out.println("篮子" + this.name + "里面装了" + this.goods.goodsName);
    }

    public void exchange(Basket b) {
        System.out.println("将" + this.name + "和" + b.name + "中的物品进行交换");
        String tmp = this.goods.goodsName;
        this.goods.setGoodsName(b.goods.getGoodsName());
        b.goods.setGoodsName(tmp);
    }
}
