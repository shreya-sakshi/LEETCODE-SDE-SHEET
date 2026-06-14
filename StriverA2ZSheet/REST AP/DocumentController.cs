[HttpPost]
[Route("api/documents")]
public IActionResult Post([FromBody] Document document)
{
    if (!ModelState.IsValid)
        return BadRequest(ModelState);

    return Ok();
}