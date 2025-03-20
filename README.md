# -
ser_name}! ما نوع المشروع الذي تريد؟ (تتحليل)",    ا تريد استخدضي! 💡"     }     for key in custom_responses:         if key in message:             return custom_responses[key]          # إذا لم يوجد رد محدد: استخدم الـ Transformers     return generate_response(message)  print(hybrid_chatbot("أريد مشروعًا عن التعليم مع الذكاء"))
