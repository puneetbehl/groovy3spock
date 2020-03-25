package example


import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.GStringExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import spock.lang.Specification

class GreetingSpec extends Specification {

    void "test canary"() {
        expect:
        true
    }

    void "test GStringExpression"() {

        setup:
        AstBuilder astBuilder = new AstBuilder()
        List<BlockStatement> statements = astBuilder.buildFromString('"from ${String s} where s == \"test\""') as List<BlockStatement>
        BlockStatement firstBlockStatement = statements[0]
        ReturnStatement returnStatement = (ReturnStatement) firstBlockStatement.statements[0]

        expect:
        returnStatement.expression
    }
}
