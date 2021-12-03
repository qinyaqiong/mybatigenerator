package generator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * 转换number为Integer的类
 * @author Administer
 *
 */
public class MyJavaTypeResovler extends JavaTypeResolverDefaultImpl {
	 
    @Override
	protected FullyQualifiedJavaType calculateBigDecimalReplacement(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer;
 
        if (column.getScale() > 0 || column.getLength() > 18 || forceBigDecimals) {
            answer = defaultType;
        } else if (column.getLength() > 9) {
            answer = new FullyQualifiedJavaType(Long.class.getName());
        } else {
            answer = new FullyQualifiedJavaType(Long.class.getName());
        }
 
        return answer;
    }
}
