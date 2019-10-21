package luyao.wanandroid.adapter
import androidx.core.text.HtmlCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import luyao.util.ktx.ext.fromN
import luyao.wanandroid.R
import luyao.wanandroid.model.bean.Article

/**
 * Created by luyao
 * on 2019/10/15 10:53
 */
class SquareAdapter(layoutResId :Int=  R.layout.item_square) : BaseQuickAdapter<Article, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: Article?) {
        item?.let {
            helper.setText(R.id.shareTitle,HtmlCompat.fromHtml(item.title,HtmlCompat.FROM_HTML_MODE_LEGACY))
            helper.setText(R.id.shareAuthor,"分享人： ${it.shareUser}")
            helper.setText(R.id.shareTime,it.niceShareDate)
        }
    }
}