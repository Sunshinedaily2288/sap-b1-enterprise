function POST(request, response) {
    var body = request.body;

    // Automation Logic: Auto-populate an integration tracking note
    if (body && !body.Notes) {
        body.Notes = "Processed via custom Service Layer Engine extension on " + new Date().toISOString();
    }

    // Core ERP Data Validation
    if (body.CardName && body.CardName.length > 50) {
        response.status = 400;
        response.body = { "error": "CardName exceeds the maximum allowed enterprise integration buffer length of 50 characters." };
        return;
    }

    response.status = 201;
    response.body = body;
}
