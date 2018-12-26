package i_introduction._7_Nullable_Types

import util.TODO
import util.doc7

fun test() {
    val s: String = "this variable cannot store null references"
    println("s = ${s}")
    val q: String? = null
    println("q = ${q}")

    if (q != null) q.length      // you have to check to dereference
    val i: Int? = q?.length      // null
    println("i = ${i}")
    val j: Int = q?.length ?: 0  // 0
    println("j = ${j}")
}

fun todoTask7(client: Client?, message: String?, mailer: Mailer): Nothing = TODO(
    """
        Task 7.
        Rewrite JavaCode7.sendMessageToClient in Kotlin, using only one 'if' expression.
        Declarations of Client, PersonalInfo and Mailer are given below.
    """,
    documentation = doc7(),
    references = { JavaCode7().sendMessageToClient(client, message, mailer) }
)

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
//    todoTask7(client, message, mailer)
//    test()
    if (client == null || message == null) return

    val personalInfo = client.personalInfo ?: return

    val email = personalInfo.email ?: return

    mailer.sendMessage(email, message)
}


class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}
